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
    
}
