package com.bounce.springtest.mvc.repository;

import com.bounce.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RealtorRepository {

    public int insertRealtor(Realtor realtor);
}
