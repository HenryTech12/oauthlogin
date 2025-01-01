package com.demo.oauthlogin.service;

import com.demo.oauthlogin.repo.*;
import com.demo.oauthlogin.dto.*;
import com.demo.oauthlogin.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.demo.oauthlogin.mapper.*;

@Service
public class UserService {
 
    @Autowired
     private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
   
      public void registerUser(UserDTO userDto) {
         if(userDto != null) { 
              System.out.println("not null");
              if(!verifyNewUsers(userDto)) {
                  System.out.println("user data");
                   UserData userData = userMapper.convertUserDTOToUserData(userDto);
                   repo.save(userData);
                  System.out.println("USER DATA SAVED");
              }
            }
       }

   public boolean verifyNewUsers(UserDTO userDto) {
        Optional<UserData> userOptionalData = repo.findByUsername(userDto.getUsername());
        return userOptionalData.isPresent();
   }

    public List<UserData> getUsers() {
          return  repo.findAll();
     }
}