package com.northcoders.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1")
public class securityController {

    @GetMapping("/open/greeting")
    public static String getStrangerWelcome (){
        return "Welcome to our website, stranger!";
    }

    @GetMapping("/protected/greeting")
    public static String getAuthenticatedWelcome(){
        return "Welcome back, my friend!";
    }

}
