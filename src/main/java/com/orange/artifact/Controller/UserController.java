package com.orange.artifact.Controller;


import com.orange.artifact.ErrorHandling.EntityNotFoundException;
import com.orange.artifact.Weather.Weather;
import com.orange.artifact.dto.LoginDTO;
import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.User;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.services.*;
import com.orange.artifact.validator.LoginDTOValidator;
import com.orange.artifact.validator.UserDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.sql.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserServices userServices;

    @Autowired
    WeatherNoteServices weatherNoteServices;

    @Autowired
    UserDTOServices userDTOServices;

    @Autowired
    WeatherNoteDTOServices weatherNoteDTOServices;

    @Autowired
    WeatherAPIServices weatherAPIServices;

    @Autowired
    UserDTOValidator userDTOValidator;

    @Autowired
    LoginDTOValidator loginDTOValidator;

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

    @RequestMapping(value = "/saveuser" , method = {POST,PUT})
    public User addUser(@RequestBody @Validated(UserDTOValidator.class)  UserDTO userDTO , BindingResult result){
        if(result.hasErrors()){
            throw new  UsernameNotFoundException("problem occured while adding a user");
        }

        logger.info("In UserController : addUser Function is called");
        User user = userDTOServices.ConvertUserDTOtoUser(userDTO);
        userServices.saveUser(user);
        return user;
    }


    @PostMapping(value = "/login")
    @RequestMapping(value = "/login" , method = {POST , PUT,GET})
    public User login(@RequestBody @Validated(LoginDTOValidator.class)  LoginDTO loginDTO, BindingResult result) {
        if(result.hasErrors()) {
            throw new UsernameNotFoundException("usr nt fnd");
        }

        System.out.println("In Login");

        User user = userServices.findUser(loginDTO.getEmail(),loginDTO.getPassword());
        /*System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getName());*/
        return user;
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) throws EntityNotFoundException {
        return userServices.getUser(userId);
    }





}
