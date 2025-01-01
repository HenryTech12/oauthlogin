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
public class HomeController {
 
      @Autowired
      private UserService userService;

     @GetMapping("/home")
     @ResponseBody
     public String home() {
       return "Welcome to home page";
     }
     
   @GetMapping("/all")
   @ResponseBody
    public List<UserData> getAll() {
        return userService.getUsers();
     }
}