package com.rakun.weatherapp.service;

import com.rakun.weatherapp.dto.LoginRequest;
import com.rakun.weatherapp.dto.RegisterRequest;
import com.rakun.weatherapp.entity.User;
import com.rakun.weatherapp.entity.WeatherQuery;
import com.rakun.weatherapp.repository.UserRepository;
import com.rakun.weatherapp.repository.WeatherQueryRepository;
import com.rakun.weatherapp.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final WeatherQueryRepository weatherQueryRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())){
            throw new RuntimeException("Username is already in use");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public Optional<User> login(LoginRequest loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public WeatherQuery saveQuery(WeatherQuery weatherQuery) {
        weatherQuery.setCreatedAt(LocalDateTime.now());
        return weatherQueryRepository.save(weatherQuery);
    }

    public List<WeatherQuery> getQueriesByUser(User user) {
        return weatherQueryRepository.findAllByUser(user);
    }

    public List<WeatherQuery> getQueriesByCity(String city) {
        return weatherQueryRepository.findByCity(city);
    }

    public List<WeatherQuery> getAllQueries() {
        return weatherQueryRepository.findAll();
    }
}
