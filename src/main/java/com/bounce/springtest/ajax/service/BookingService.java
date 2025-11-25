package com.bounce.springtest.ajax.service;

import com.bounce.springtest.ajax.domain.Booking;
import com.bounce.springtest.ajax.repository.BookingRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookingList() {

        List<Booking> bookingList = bookingRepository.selectBooking();

        return bookingList;

    }

    public int deleteBooking(int id) {

        int count = bookingRepository.deleteBooking(id);

        return count;
    }

    public int createBooking(
            String name
            , int headcount
            , int day
            , LocalDate date
            , String phoneNumber) {

        int count = bookingRepository.insertBooking(name, headcount, day, date, phoneNumber, "대기중");

        return count;
    }

    public Booking getBooking(String name, String phoneNumber) {
        Booking booking = bookingRepository.selectBookingParameter(name, phoneNumber);

        return booking;
    }

}
