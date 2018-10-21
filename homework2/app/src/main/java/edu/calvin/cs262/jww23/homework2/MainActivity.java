package edu.calvin.cs262.jww23.homework2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

import edu.calvin.cs262.jww23.lab05.R;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String>{


    private EditText mPlayerInput;
    private TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerInput = (EditText)findViewById(R.id.PlayerInput);
        mInfoText = (TextView) findViewById(R.id.InfoText);
        if(getSupportLoaderManager().getLoader(0)!=null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }


    public void fetchID(View v) {

        String queryString = mPlayerInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);


        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);



        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            mInfoText.setText(R.string.loading);
            Bundle queryBundle = new Bundle();
            queryBundle.putString("mPlayerInput", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle,this);
        }

        else {
            mInfoText.setText("Please check your network connection and try again.");
            }


    }


    @Override
    public Loader<String> onCreateLoader(int i, Bundle args) {
        Log.d("args bundle", args.getString("mPlayerInput"));
        return new PlayerLoader(this, args.getString("queryString"));
    }


    @Override
    public void onLoadFinished( Loader<String> loader, String s) {
        String queryInt = s.split("%")[0];
        s = s.split("%")[1];
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            mInfoText.setText("");
            //Iterate through the results
            for(int i = 0; i<itemsArray.length(); i++){
                String playerID=null;
                String name=null;
                String email=null;
                JSONObject info = itemsArray.getJSONObject(i); //Get the current item

                playerID = info.getString("id");
                email = info.getString("emailAddress");
                try {
                    name = info.getString("name");
                } catch (Exception e){
                    e.printStackTrace();
                    name = "no name";
                }
                if (queryInt.equals("")){
                    mInfoText.append(playerID + ", " + name + ", " + email + "\n");

                } else {
                    if (queryInt.equals(playerID)) {
                        mInfoText.append(playerID + ", " + name + ", " + email);
                        break;
                    }
                }
            }
        } catch (Exception e){
            mInfoText.setText("");
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset( Loader<String> loader) {

    }
}
