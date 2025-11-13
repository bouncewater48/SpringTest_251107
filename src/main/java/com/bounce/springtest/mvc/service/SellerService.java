package com.bounce.springtest.mvc.service;

import com.bounce.springtest.mvc.domain.Seller;
import com.bounce.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller getSellerList() {

        // new_user 테이블에서 가장 최근 추가된 행 조회
        Seller seller = sellerRepository.selectLastUser();

        return seller;
    }

    public int createSeller(
        String nickname
        , double temperature
        , String profile_Image) {

        int count = sellerRepository.insertSeller(nickname, temperature, profile_Image);

        return count;

    }

}
