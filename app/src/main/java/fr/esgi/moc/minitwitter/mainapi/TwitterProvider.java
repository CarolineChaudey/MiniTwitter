package fr.esgi.moc.minitwitter.mainapi;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by caroline on 09/05/2018.
 */

public class TwitterProvider {

    private static final String BASE_URL = "https://api.twitter.com/";
    private static final String JSON_FORMAT = "json";
    private static final String API_KEY = "6Hw3rFghxoQLVDBHjN183ovLI";
    private static final String API_SECRET = "4V0hGqZVPc4Oge8eFDMGphjuWY8TPZ2CzBTlFQ4NhrgjkMhJlc";

    private TwitterService twitterService;
    private static final String TAG = "TwitterProvider";


    public TwitterProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
        twitterService = retrofit.create(TwitterService.class);
    }

    public Call<String> getToken() throws UnsupportedEncodingException {
        String bearerToken = createBearerToken();
        byte[] bytesBearerToken = bearerToken.getBytes("UTF-8");
        String base64BearerToken = "Basic " + Base64.encodeToString(bytesBearerToken, Base64.NO_WRAP);
        Log.d(TAG, base64BearerToken.trim());

        return twitterService.getToken(base64BearerToken.trim(), "grant_type=client_credentials");
    }

    private String createBearerToken() {
        Uri uriParsedKey = Uri.parse(API_KEY);
        Uri uriParsedSecret = Uri.parse(API_SECRET);
        return uriParsedKey.toString() + ":" + uriParsedSecret.toString();
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        return okBuilder.build();
    }
}
