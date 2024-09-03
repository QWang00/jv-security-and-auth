package com.northcoders.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public static String getAuthenticatedWelcome(@AuthenticationPrincipal OAuth2User user){

        return "Welcome back, my friend! " + user.getAttribute("login");

    }


}
