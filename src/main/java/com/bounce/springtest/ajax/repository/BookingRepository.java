package com.bounce.springtest.ajax.repository;

import com.bounce.springtest.ajax.domain.Booking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingRepository {

    public List<Booking> selectBooking();


}
