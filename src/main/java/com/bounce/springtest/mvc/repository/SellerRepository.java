package com.bounce.springtest.mvc.repository;

import com.bounce.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {

    public Seller selectSeller();

    public int insertSeller(
        @Param("nickname") String nickname
        , @Param("temperature") double temperature
        , @Param("profileImage") String profile_image);

}
