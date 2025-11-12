package com.bounce.springtest.mybatis;

import com.bounce.springtest.mybatis.domain.RealEstate;
import com.bounce.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/mybatis/real-estate")
@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate realEstate(@RequestParam("id") int id) {
        
        // 전달 받은 id와 일치하는 매물 정보 얻어오기
        RealEstate realEstate = realEstateService.getRealEstate(id);

        return realEstate;

    }

    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
        
        // 전달받은 월세 보다 낮은 매물 리스트 얻어오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);

        return realEstateList;
    }

    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> realEstateAreaAndPrice(
            @RequestParam("area") int area
            , @RequestParam("price") int price) {

        // 면적과 가격에 대한 조건에 대응 되는 매물 리스트 얻어 오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);

        return realEstateList;

    }

    @ResponseBody
    @RequestMapping("/insert/1")
    public String insertRealEstate() {
//        int count = realEstateService.createRealEstate(3, "푸르지용 리버 303동 1104호", 89,"매매", 100000);


        RealEstate realEstate = new RealEstate();
        realEstate.setAddress("썅떼빌리버 오피스텔 814호");
        realEstate.setArea(45);
        realEstate.setType("월세");
        realEstate.setPrice(100000);
        realEstate.setRentPrice(120);

        int count = realEstateService.createRealEstateObject(realEstate);

        return "입력 성공 : " + count;
    }

}
