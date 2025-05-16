package com.rakun.weatherapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_queries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String countryCode;

    @Column(columnDefinition = "TEXT")
    private String weatherJson;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
