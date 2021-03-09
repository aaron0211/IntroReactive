package com.aaron.ejempRetrofit.service;

import com.aaron.ejempRetrofit.domain.Weather;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.aaron.ejempRetrofit.util.Constans.URL;

public class WeatherService {

    private WeatherApiService api;

    public WeatherService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(WeatherApiService.class);
    }

    public List<Weather> getWoeid(String name){
        Call<List<Weather>> listWoeid = api.getWoeid(name);
        try{
            Response<List<Weather>> response = listWoeid.execute();
            return response.body();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }
//
//    public Observable<List<Weather>> getWoeid(String name) {
//        return api.getWoeid(name);
//    }

    public Observable<Weather> getLocation(String woeid){
        return api.getLocation(woeid);
    }
}
