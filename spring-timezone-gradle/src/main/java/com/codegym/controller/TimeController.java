package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
//        lấy ra thời gian hiện tại
        Date date = new Date();

//        lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();

//        lấy ra time zone của thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);

//        tính thời gian hiện tại của một thành phố
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

//        cài đặt thời gian cho biến date thành thời gian hiện tại của thành phố cụ thể
        date.setTime(locale_time);

//        chuyển dữ liệu và chuyển qua view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
