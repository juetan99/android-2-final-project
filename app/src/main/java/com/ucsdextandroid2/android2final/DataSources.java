package com.ucsdextandroid2.android2final;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.util.Collections;
import java.util.List;

public class DataSources {

    private static DataSources instance;

    private DataAPI dataApi;

    private DataSources(){
        Gson gson= new GsonBuilder()
                .create();

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.level(HttpLoggingInterceptor.Level.BODY);

        this.dataApi = new Retrofit.Builder()
                .baseUrl("https://developer.nps.gov/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
              //  .client(new OkHttpClient.Builder().addInterceptor(logger).build())
                .build()
                .create(DataAPI.class);

    }

    public static DataSources getInstance() {
        if(instance == null)
            instance = new DataSources();

        return instance;
    }

    public void getParks(Callback<List<Park>> callback) {

        dataApi.getParks().enqueue(new retrofit2.Callback<ParkResponse>() {
            @Override
            public void onResponse(Call<ParkResponse> call, Response<ParkResponse> response) {
                if(response.isSuccessful())
                    callback.onDataFetched(response.body().getParks());
                else
                    callback.onDataFetched(Collections.emptyList());
            }

            @Override
            public void onFailure(Call<ParkResponse> call, Throwable t) {
                callback.onDataFetched(Collections.emptyList());
            }
        });
    }

    public interface Callback<T> {
        void onDataFetched(T data);
    }

    private interface DataAPI{
        @GET("parks?api_key=" + BuildConfig.api_key)
        Call<ParkResponse> getParks();
    }

}
