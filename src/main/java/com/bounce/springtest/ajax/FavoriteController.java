package com.bounce.springtest.ajax;

import com.bounce.springtest.ajax.domain.Favorite;
import com.bounce.springtest.ajax.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

    // IoC : 제어의 역전
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/list")
    public String favoriteList(Model model) {
        List<Favorite> favoriteList = favoriteService.getFavoriteList();

        model.addAttribute("favoriteList", favoriteList);

        return "ajax/favorite/list";
    }

    // 즐겨찾기 추가 API
    @ResponseBody
    @GetMapping("/add")
    public Map<String, String> addFavorite(
            @RequestParam("name") String name
            , @RequestParam("url") String url) {

        int count = favoriteService.createFavorite(name, url);

        Map<String, String> resultMap = new HashMap<>();
        // 성공 : {"result":"success"}
        // 실패 : {"result":"fail"}
        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

    @GetMapping("/form")
    public String favoriteForm() {
        return "ajax/favorite/form";
    }

    @ResponseBody
    @GetMapping("duplicate-url")
    public Map<String, Boolean> isDuplicateAddress(@RequestParam("address") String address) {

        Map<String, Boolean> resultMap = new HashMap<>();

        if(favoriteService.isDuplicateAddress(address)) {
            resultMap.put("isDuplicate", true);
        } else {
            resultMap.put("isDuplicate", false);
        }

        return resultMap;

    }

 }
