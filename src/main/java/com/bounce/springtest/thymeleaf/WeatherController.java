package com.bounce.springtest.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

    @GetMapping("/list")
    public String list() {
        return "thymeleaf/weatherhistory/list";
    }

    @GetMapping("/form")
    public String form() {
        return "thymeleaf/weatherhistory/form";
    }


}
