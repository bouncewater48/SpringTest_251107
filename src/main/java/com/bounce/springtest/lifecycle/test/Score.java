package com.bounce.springtest.lifecycle.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Score {

    @ResponseBody
    @RequestMapping("/lifecycle/test01/1")
    public String htmlResponse() {
        return "<html>\n" +
                "   <head><title>테스트 프로젝트 완성</title></head>\n" +
                "      <body>\n" +
                "       <h2>테스트 프로젝트 완성</h2>\n" +
                "       <div>해당 프로젝틀르 통해서 문제 풀이를 진행 합니다</div>\n" +
                "       </body>\n" +
                "</html>";
    }

    @ResponseBody
    @RequestMapping("/lifecycle/test01/2")
    public Map<String, Integer> mapResponse() {

        Map<String, Integer> scoreMap = new HashMap<>();

        scoreMap.put("국어", 80);
        scoreMap.put("수학", 90);
        scoreMap.put("영어", 85);

        return scoreMap;

    }

}
