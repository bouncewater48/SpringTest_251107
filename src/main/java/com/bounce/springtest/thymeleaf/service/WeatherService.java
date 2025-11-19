package com.bounce.springtest.thymeleaf.service;

import com.bounce.springtest.thymeleaf.domain.Weather;
import com.bounce.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
