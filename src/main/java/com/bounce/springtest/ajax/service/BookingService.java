package com.bounce.springtest.ajax.service;

import com.bounce.springtest.ajax.domain.Booking;
import com.bounce.springtest.ajax.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookingList() {

        List<Booking> bookingList = bookingRepository.selectBooking();

        return bookingList;

    }

}
