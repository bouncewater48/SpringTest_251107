package com.bounce.springtest.thymeleaf.service;

import com.bounce.springtest.thymeleaf.domain.Weather;
import com.bounce.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<Weather> getWeatherHistory() {
        // weatherhistory 테이블 모든 행 조회
        
        List<Weather> weatherHistory = weatherRepository.selectWeatherHistory();

        return weatherHistory;
    }

    public int createWeather(
            LocalDate date
            , String weather
            , double temperatures
            , double precipitation
            , String microDust
            , double windSpeed) {

        int count = weatherRepository.insertWeather(weather, date, temperatures, precipitation, microDust, windSpeed);

        return count;
    }

    public int createWeatherByObject(Weather weather) {
        int count = weatherRepository.insertWeatherByObject(weather);
        return count;
    }

}
