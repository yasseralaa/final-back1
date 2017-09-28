package com.orange.artifact.controller;



import com.orange.artifact.dro.LoginDRO;
import com.orange.artifact.dro.UserDRO;
import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.model.User;
import com.orange.artifact.services.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserServices userServices;

    @Autowired
    WeatherNoteServices weatherNoteServices;



    @Autowired
    WeatherAPIServices weatherAPIServices;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/saveuser" , method = {POST,PUT})
    public UserDTO addUser(@Valid @RequestBody UserDRO userDRO , BindingResult result){
        if(result.hasErrors()){
            throw new UsernameNotFoundException("problem occured while adding a user");
        }
        User user = modelMapper.map(userDRO, User.class);
        userServices.saveUser(user);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }


    @PostMapping(value = "/login")
    @RequestMapping(value = "/login" , method = {POST , PUT,GET})
    public UserDTO login(@Valid @RequestBody LoginDRO loginDRO, BindingResult result) throws EntityNotFoundException {
        if(result.hasErrors()) {
            throw new UsernameNotFoundException("usr nt fnd");
        }
        System.out.println("test test1");
        User user = modelMapper.map(loginDRO, User.class);
        user = userServices.findUser(user.getEmail(),user.getPassword());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @GetMapping(value = "/{userId}")
    public UserDTO getUser(@PathVariable("userId") Integer userId) throws EntityNotFoundException {
        User user = userServices.getUser(userId);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}