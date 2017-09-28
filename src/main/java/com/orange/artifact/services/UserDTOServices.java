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

    @Autowired
    RoleServices roleServices;

    public UserDTO ConvertUsertoUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
