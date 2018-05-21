package umtkas.com.lms.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static  ApiClient apiClient;


    public static ApiClient getClient(){
        if (apiClient == null){
            Retrofit retrofit;

            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(Server.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            retrofit = retrofitBuilder.build();
            apiClient = retrofit.create(ApiClient.class);
        }
        return apiClient;
    }


}



