package edu.calvin.cs262.jww23.homework2;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
/**
* PLayerLoader class allows the program to determine which player is being requested
*/


public class PlayerLoader extends AsyncTaskLoader<String> {

    private String mQueryString;


    public PlayerLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getPlayerInfo(mQueryString);
    }

}
