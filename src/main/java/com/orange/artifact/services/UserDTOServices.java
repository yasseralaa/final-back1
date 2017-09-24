package com.orange.artifact.services;

import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.model.Role;
import com.orange.artifact.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userDTOServices")
public class UserDTOServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoleServices roleServices;

    public User ConvertUserDTOtoUser(UserDTO userDTO){

        logger.info("In UserDTOServices : ConvertUserDTOtoUser Function is called");

        User user = new User();
        Role role = roleServices.findrole(userDTO.getRoleId());

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setRole(role);

        return user;
    }
}
