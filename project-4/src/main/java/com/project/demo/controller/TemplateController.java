package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Habib
 * @on 10/10/21 - 8:49 AM
 */
@Controller
@RequestMapping("api")
public class TemplateController {
    @Value("${developer.name}")
    private String developerName;

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("developerName", developerName);
        model.addAttribute("serverTime", LocalDateTime.now());
        return "hello";
    }
}
