package com.example.kmupbl3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"", "/index"})
    public String hello() {
        return "redirect:/neighbor-ad";
    }

    @GetMapping("/neighbor-ad")
    public String getAdPage() {
        return "react/index";  // TODO merge with react(frontend)
    }
}