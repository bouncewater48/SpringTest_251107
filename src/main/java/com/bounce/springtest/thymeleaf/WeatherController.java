package com.bounce.springtest.thymeleaf;

import com.bounce.springtest.thymeleaf.domain.Weather;
import com.bounce.springtest.thymeleaf.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/list")
    public String weatherHistory(Model model) {
//    public String list(@RequestParam("id") int id) {

//             WeatherService에서 호출이 아닌, AutoWired로 생성한 객체 호출임
        List<Weather> weatherHistory = weatherService.getWeatherHistory();
//        List<Weather> weatherHistory = WeatherService.getWeatherHistory(id);

        model.addAttribute("weatherHistory", weatherHistory);

        return "thymeleaf/weatherHistory/list";
    }

    @GetMapping("/form")
    public String form() {
        return "thymeleaf/weatherHistory/form";
    }

}
