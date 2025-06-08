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

    @GetMapping("/factorial")
    public String calcfactorial(Model model, @RequestParam(value = "name") Optional<String> name) {
        int fanc = calcService.fact(5);
        model.addAttribute("name", name.orElse("World"));
        model.addAttribute("fanc", fanc);
        return "calc/fanc/index";
    }

    @GetMapping("/fibonacci")
    public String calcfibo(Model model,
            @RequestParam(value = "name") Optional<String> name,
            @RequestParam(value = "number", defaultValue = "5") int number) {
        int fanc = calcService.fibo(number);
        model.addAttribute("name", name.orElse("World"));
        model.addAttribute("fanc", fanc);
        return "calc/fanc/index";
    }
}
