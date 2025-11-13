package com.bounce.springtest.mybatis.service;

import com.bounce.springtest.mybatis.domain.RealEstate;
import com.bounce.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    // 전달 받은 id와 일치하는 매물 정보 얻어오기
    public RealEstate getRealEstate(int id) {

        // real_estate 테이블에서 전달 받은 id와 일치하는 행 조회
        RealEstate realEstate = realEstateRepository.selectRealEstate(id);

        return realEstate;
        
    }

    // 전달받은 월세 보다 낮은 매물 리스트 얻어오기
    public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
        
        // real_estate 테이블에서 전달받은 월세보다 낮은 행들 조회
        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);

        return realEstateList;
    }

    public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {

        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);

        return realEstateList;

    }

    public int createRealEstate(
            int realtorId
            , String address
            , int area
            , String type
            , int price) {

        int count = realEstateRepository.insertRealtorEstate(realtorId, address, area, type, price);

        return count;

    }

    public int createRealEstateObject(RealEstate realEstate) {

        int count = realEstateRepository.InsertRealEstateObject(realEstate);

        return count;

    }

    // 특정 id의 매물 정보와 type 과 가격을 수정하는 기능
    public int updateRealEstate(int id, String type, int price) {

        int count = realEstateRepository.updateRealEstate(id, type, price);

        return count;
    }

    public int deleteRealEstate(int id) {

        int count = realEstateRepository.deleteRealEstate(id);

        return count;

    }

}
