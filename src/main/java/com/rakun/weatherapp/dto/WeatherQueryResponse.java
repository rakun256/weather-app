package com.rakun.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class WeatherQueryResponse {
    private String city;
    private String countryCode;
    private String weatherJson;
    private LocalDateTime timestamp;
}