package com.ebadger.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
public class IndexController {

    @RequestMapping("/time")
    public String getTime() {
        return "The time is: " + new Date().toString();
    }
}