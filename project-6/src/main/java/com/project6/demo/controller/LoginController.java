package com.project6.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Habib
 * @on 10/13/21 - 8:50 AM
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }

/*    @PostMapping ("/login")
    public String loginPost(String username,String password){
        return "redirect:/index";
    }*/
}
