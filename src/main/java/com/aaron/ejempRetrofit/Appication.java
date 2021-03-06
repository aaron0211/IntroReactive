package com.aaron.ejempRetrofit;

import com.aaron.ejempRetrofit.domain.Weather;
import com.aaron.ejempRetrofit.service.WeatherService;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executors;

public class Appication {
    public static void main(String[] args){

        final WeatherService weatherService = new WeatherService();

        System.out.println("Lista de ciudades....");

        weatherService.getWoeid("ma")
                .flatMap(Observable::from)
                .doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(System.out::println);

        weatherService.getLocation("766273")
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(System.out::println);
        //List<Weather> woeid = weatherService.getWoeid("san");

        //Weather locations = weatherService.getLocation(woeid.get(0).getWoeid());

        //System.out.println("Primera ciudad");
        //System.out.println(locations);
    }
}
