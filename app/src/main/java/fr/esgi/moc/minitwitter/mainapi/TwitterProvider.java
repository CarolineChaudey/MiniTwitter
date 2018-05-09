package fr.esgi.moc.minitwitter.mainapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by caroline on 09/05/2018.
 */

public class TwitterProvider {
    //private static final String BASE_URL = "https://swapi.co/api/";
    private static final String JSON_FORMAT = "json";

    private TwitterService twitterService;


    public TwitterProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
        twitterService = retrofit.create(TwitterService.class);
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        return okBuilder.build();
    }
}
