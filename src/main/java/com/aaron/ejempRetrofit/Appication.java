package com.aaron.ejempRetrofit;

import com.aaron.ejempRetrofit.domain.Weather;
import com.aaron.ejempRetrofit.service.WeatherService;
import com.aaron.ejempRetrofit.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rx.schedulers.Schedulers;
import rx.Observable;

import java.util.concurrent.Executors;

public class Appication extends Application {
    public static void main(String[] args){
        launch();

//        System.out.println("Lista de ciudades....");

//        weatherService.getWoeid("ma")
//                .flatMap(Observable::from)
//                .filter(weather -> weather.getWoeid()>2000000)
//            .doOnCompleted(() -> System.out.println("Listado descargado"))
//            .doOnError(throwable -> System.out.println(throwable.getMessage()))
//            .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
//            .subscribe(System.out::println);
//
//        weatherService.getLocation("766273")
//                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
//            .subscribe(System.out::println);


//        System.out.println("Fin del programa");
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        AppController controller = new AppController();
        loader.setLocation(R.getUI("panelWeather.fxml"));
        loader.setController(controller);
        VBox vBox = loader.load();

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
