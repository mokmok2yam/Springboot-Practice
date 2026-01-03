package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloController {
    @GetMapping("hello")
    public String getName(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-name";
    }

}
