package com.bounce.springtest.thymeleaf.repository;

import com.bounce.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherHistory();


}
