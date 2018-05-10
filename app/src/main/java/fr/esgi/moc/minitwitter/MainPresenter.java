package fr.esgi.moc.minitwitter;


import android.util.Log;

import java.io.UnsupportedEncodingException;

import fr.esgi.moc.minitwitter.mainapi.TwitterProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by caroline on 10/05/2018.
 */

public class MainPresenter {

    private String token;
    private MainActivity mainActivity;
    private static final String TAG = "MainPresenter";

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        getTwitterApiToken();
    }

    public void getTwitterApiToken() {
        TwitterProvider twitterProvider = new TwitterProvider();
        try {
            Call<String> res = twitterProvider.getToken();
            res.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d(TAG, response.toString());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
