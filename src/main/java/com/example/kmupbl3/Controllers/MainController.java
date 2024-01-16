package com.example.kmupbl3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"", "/index"})
    public String hello() {
        return "redirect:/neighbor-ad";
    }
}