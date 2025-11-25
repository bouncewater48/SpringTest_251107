package com.bounce.springtest.ajax;

import com.bounce.springtest.ajax.domain.Booking;
import com.bounce.springtest.ajax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/main")
    public String bookingMain() {
        return "ajax/booking/main";
    }

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

    @ResponseBody
    @GetMapping("/remove")
    public Map<String, String> removeBooking(@RequestParam("id") int id) {

        int count = bookingService.deleteBooking(id);

        Map<String, String> resultMap = new HashMap<>();
        // {"result":"success"}
        // {"result":"fail"}

        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;

    }

    @ResponseBody
    @GetMapping("/add")
    public Map<String, String> addBooking(
            @RequestParam("name") String name
            , @RequestParam("headcount") int headcount
            , @RequestParam("day") int day
            , @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date // 2025년 9월 15일
            , @RequestParam("phoneNumber") String phoneNumber) {

        int count = bookingService.createBooking(name, headcount, day, date, phoneNumber);

        Map<String, String> resultMap = new HashMap<>();
        // {"result":"success"}
        // {"result":"fail"}

        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;

    }

    // 이름과 전화번화가 일치하는 예약정보 API
    @ResponseBody
    @GetMapping("/search")
    public Map<String, Object> searchBooking(
            @RequestParam("name") String name
            , @RequestParam("phoneNumber") String phoneNumber) {
        // 일치하는 정보는 하나만 존재한다
        Booking booking = bookingService.getBooking(name, phoneNumber);

        // 조회결과
        // 조회 성공 : {"result":"success", "data":{"id": 10,"name": "김인규", "headcount": 2,...}}
        // 조회 실패 : {"result":"fail"}

        Map<String, Object> resultMap = new HashMap<>();

        if(booking != null) {
            resultMap.put("result", "success");
            resultMap.put("data", booking);
        } else {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }
}
