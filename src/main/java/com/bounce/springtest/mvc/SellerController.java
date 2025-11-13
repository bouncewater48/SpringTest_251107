package com.bounce.springtest.mvc;

import com.bounce.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(

        @RequestParam("nickname") String nickname
        , @RequestParam("temperature") double temperature
        , @RequestParam("profileImage") String profile_image) {

        int count = sellerService.createSeller(nickname, temperature, profile_image);

        return "입력 성공!";
    }




}
