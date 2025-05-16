package com.rakun.weatherapp.repository;

import com.rakun.weatherapp.entity.User;
import com.rakun.weatherapp.entity.WeatherQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WeatherQueryRepository extends JpaRepository<WeatherQuery, Long> {
    List<WeatherQuery> findByCity(String city);
    List<WeatherQuery> findAllByUser (User user);
}