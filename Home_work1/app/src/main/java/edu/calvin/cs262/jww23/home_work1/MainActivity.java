package edu.calvin.cs262.jww23.home_work1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.calvin.cs262.jww23.home_work1.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    EditText Value1, Value2;
    Button button1, button2, button3,button4;
// button1 = add
// button2 = Subtract
// button3 = Multiply
// button4 = Divide


    float res_num;
    int val1, val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);

        Value1 = (EditText)findViewById(R.id.Value1);
        Value2 = (EditText)findViewById(R.id.Value2);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        //ADD





    }

    @Override
    public void onClick(View v) {

        //ADD
        button1.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 + val2;
                result.setText(String.valueOf(res_num));


            }
        });
        // Subtract
        button2.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 - val2;
                result.setText(String.valueOf(res_num));


            }
        });

        //Multiple
        button3.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 * val2;
                result.setText(String.valueOf(res_num));


            }
        });

        // Divide
        button4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 / val2;
                result.setText(String.valueOf(res_num));


            }


        });

    }

}
