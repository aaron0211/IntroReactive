package com.aaron.ejempRetrofit.domain;

import lombok.*;

@Data
@ToString
public class Weather {

    private String title;
    private String latt_long;
    private String woeid;
}
