package com.demo.oauthlogin.config;
import com.demo.oauthlogin.model.*;
import com.demo.oauthlogin.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

     @Autowired
      private UserRepository repo;
   
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          UserData userData = repo.findByUsername(username)
                      .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
         
           return new UserPrincipal(userData);
     }

}