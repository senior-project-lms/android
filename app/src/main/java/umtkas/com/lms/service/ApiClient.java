package umtkas.com.lms.service;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.models.Grade;
import umtkas.com.lms.models.Resource;

public interface ApiClient{

    @FormUrlEncoded
    @POST("oauth/token")
    Call<JsonObject> authorize(@Header("Authorization") String credentials, @Field("grant_type") String grantType, @Field("username")  String username, @Field("password") String password);

    @GET("api/me/courses")
    Call<List<Course>> getCourses(@Header("Authorization") String credentials, @Query(value = "access_token") String accessToken);


    ///api/course/${coursePublicKey}/grades

    @GET("api/course/{publicKey}/student-grades")
    Call<List<Grade>> getGrades(@Header("Authorization") String credentials, @Path("publicKey") String publicKey, @Query(value = "access_token") String accessToken);

    @GET("api/course/{publicKey}/announcements/{page}")
    Call<List<Announcement>> getAnnouncements(@Header("Authorization") String credentials, @Path("publicKey") String publicKey, @Path("page") int page,  @Query(value = "access_token") String accessToken);

    @GET("api/course/{publicKey}/resources")
    Call<List<Resource>> getResource(@Header("Authorization") String credentials, @Path("publicKey") String publicKey, @Query(value = "access_token") String accessToken);


}
