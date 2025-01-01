package com.demo.oauthlogin.mapper;

import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.oauthlogin.model.*;
import com.demo.oauthlogin.dto.*;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserMapper {

       @Autowired
       private ModelMapper modelMapper;
       @Autowired
       private PasswordEncoder passwordEncoder;

       public UserDTO convertUserDataToUserDTO(UserData userData) {
             UserDTO userDto = modelMapper.map(userData, UserDTO.class);
             return userDto;
      }
     public UserData convertUserDTOToUserData(UserDTO userDto) {
             UserData userData = modelMapper.map(userDto, UserData.class);
             userData.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return userData;
      }
}