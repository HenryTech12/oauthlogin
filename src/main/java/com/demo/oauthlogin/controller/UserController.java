package com.demo.oauthlogin.controller;

import com.demo.oauthlogin.dto.*;
import com.demo.oauthlogin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.demo.oauthlogin.model.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ModelAttribute; 

@Controller
public class UserController {

    @Autowired
    private UserService userService;

     @GetMapping("/login")
     public String login(Model model) {
       model.addAttribute("userDto", new UserDTO());
       return "login.html";
     }

     @GetMapping("/signup")
    public String signup(Model model) {
       model.addAttribute("userDto", new UserDTO());
       return "signup.html";
    }

    
   @GetMapping("/logout-confirm")
    public String logout() {
        return "logout.html";
     }

     
   @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "login.html";
     }


    @PostMapping("/register")
    public String register(@ModelAttribute UserDTO userDto, Model model) {
        //save user
        System.out.println(userDto.getUsername());
        if(!userService.verifyNewUsers(userDto)) {
            userService.registerUser(userDto);
            userDto.setPassword(null);
            model.addAttribute("userDto", userDto); 
            return "login.html";
         }
         else {   
             System.out.println("Username Already Exists");
             model.addAttribute("userDto", new UserDTO());
             model.addAttribute("rMessage", "Username already exists");
         }
        return "signup.html";
   }
}