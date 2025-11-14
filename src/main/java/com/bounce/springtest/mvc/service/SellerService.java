package com.bounce.springtest.mvc.service;

import com.bounce.springtest.mvc.domain.Seller;
import com.bounce.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public int createSeller(
         String nickname
        , double temperature
        , String profileImage) {

        int count = sellerRepository.insertSeller(nickname, temperature, profileImage);

        return count;
    }

    public Seller getLastSeller() {

        Seller seller = sellerRepository.selectLastSeller();

        return seller;
    }

    public Seller getSeller(int id) {
        Seller seller = sellerRepository.selectSeller(id);
        return seller;
    }

}
