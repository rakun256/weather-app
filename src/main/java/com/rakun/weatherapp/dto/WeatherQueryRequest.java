package com.rakun.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherQueryRequest {
    private String city;
    private String countryCode;
}
