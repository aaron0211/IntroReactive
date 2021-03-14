package com.aaron.ejempRetrofit;

import com.aaron.ejempRetrofit.domain.Weather;
import com.aaron.ejempRetrofit.service.WeatherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;

public class AppController implements Initializable {

    public TableView tvAll;
    public Button btSearch;
    public TextField tfSearch;

    private ObservableList<Weather> lstWeather;

    WeatherService weatherService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherService = new WeatherService();

        lstWeather = FXCollections.observableArrayList();
        tvAll.setItems(lstWeather);

        fijarColumnas();
//        cargarLista();
    }

    private void cargarLista(String name){
        tvAll.getItems().clear();

        weatherService.getWoeid(name)
                .flatMap(Observable::from)
            .doOnCompleted(() -> System.out.println("Listado descargado"))
            .doOnError(throwable -> System.out.println(throwable.getMessage()))
            .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
            .subscribe(weather -> lstWeather.add(weather));

//        tvAll.setItems(FXCollections.observableArrayList(weatherService.getWoeid(name)));
    }

    private void fijarColumnas(){
        Field[] fields = Weather.class.getDeclaredFields();
        for (Field field: fields){
            TableColumn<Weather,String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tvAll.getColumns().add(column);
        }
        tvAll.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void search(ActionEvent event){
        cargarLista(tfSearch.getText());
    }
}
