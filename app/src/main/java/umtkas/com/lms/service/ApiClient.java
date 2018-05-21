package umtkas.com.lms.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiClient{

    @FormUrlEncoded
    @POST("oauth/token")
    Call<JsonObject> authorize(@Header("Authorization") String credentials, @Field("grant_type") String grantType, @Field("username")  String username, @Field("password") String password);


}
