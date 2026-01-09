package com.example.test_hand_on.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    @GetMapping("/")
        public String home(){
            return "home";
        }

}
