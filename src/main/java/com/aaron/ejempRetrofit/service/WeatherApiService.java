package com.aaron.ejempRetrofit.service;

import com.aaron.ejempRetrofit.domain.Weather;
import retrofit2.Call;
import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface WeatherApiService {

    @GET("/api/location/search/")
    Observable<List<Weather>> getWoeid(@Query("query") String name);

    @GET("/api/location/{name}")
    Observable<Weather> getLocation(@Path("name") String woeid);
}
