package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("")
    public String hello(Model model, @RequestParam(value = "name") Optional<String> name) {
        model.addAttribute("name", name.orElse("World"));
        return "index";
    }

}
