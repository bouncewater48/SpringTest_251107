package com.bounce.springtest.ajax;

import com.bounce.springtest.ajax.domain.Booking;
import com.bounce.springtest.ajax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    public String bookingList(Model model) {
        List<Booking> bookingList = bookingService.getBookingList();

        model.addAttribute("bookingList", bookingList);

        return "ajax/booking/list";
    }

    @GetMapping("/form")
    public String bookingForm() {
        return "ajax/booking/form";
    }


}
