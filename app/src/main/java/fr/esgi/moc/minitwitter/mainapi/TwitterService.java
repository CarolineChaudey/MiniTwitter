package fr.esgi.moc.minitwitter.mainapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by caroline on 09/05/2018.
 */

public interface TwitterService {
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8")
    @POST("oauth2/token")
    Call<String> getToken(@Header("Authorization") String auth, @Body String body);
}
