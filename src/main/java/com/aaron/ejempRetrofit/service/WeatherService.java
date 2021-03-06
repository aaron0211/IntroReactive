package com.aaron.ejempRetrofit.service;

import com.aaron.ejempRetrofit.domain.Weather;
import rx.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.aaron.ejempRetrofit.util.Constans.URL;

public class WeatherService {

    private WeatherApiService api;

    public WeatherService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(WeatherApiService.class);
    }

    public Observable<List<Weather>> getWoeid(String name){
        return api.getWoeid(name);
    }

    public Observable<Weather> getLocation(String woeid){
        return api.getLocation(woeid);
    }
}
