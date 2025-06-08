package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.CalcService;

@Controller
@RequestMapping("/calc")
public class CalcController {

    private CalcService calcService;

    CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/fanc")
    public String calcfactorial(Model model, @RequestParam(value = "name") Optional<String> name) {
        int fanc = calcService.fanc(5);
        model.addAttribute("name", name.orElse("World"));
        model.addAttribute("fanc", fanc);
        return "calc/fanc/index";
    }
}
