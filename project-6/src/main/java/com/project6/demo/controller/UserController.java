package com.project6.demo.controller;

import com.project6.demo.entity.User;
import com.project6.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Habib
 * @on 10/11/21 - 8:39 AM
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signup(User user){
        /*userRepository.save(user);*/
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "adduser";
        }
        userRepository.save(user);
        return "redirect:/index";// önemli redirect:/index
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, Model model,@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "updateuser";
        }
    userRepository.save(user);
        return "redirect:/index";// önemli redirect:/index
    }
    @GetMapping("/edit/{id}")
    public String showUserProfile(@PathVariable int id, Model model){
        Optional<User> user= userRepository.findById(id);
        User user1=user.get();
        model.addAttribute("user", user1);
        return "updateuser";// önemli redirect:/index
    }

    @GetMapping("/index")
    public String getUsers(Model model){
/*        Iterable<User> users=userRepository.findAll();
        List<User> user=new ArrayList<>();
        users.forEach(user::add);*/
        model.addAttribute("user",userRepository.findAll());
        return "index";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping ("/delete/{id}")
    public String deleteUser( @PathVariable int id ,Model model){
       User user= userRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("invalid user id : "+id));
       model.addAttribute("user",user);
        return "deleteuser";// önemli redirect:/index
    }

    @PostMapping ("/delete/{id}")
    public String deleteUser( @PathVariable int id ){
          userRepository.delete(userRepository.findById(id).get());
        return "redirect:/index";// önemli redirect:/index
    }

}
