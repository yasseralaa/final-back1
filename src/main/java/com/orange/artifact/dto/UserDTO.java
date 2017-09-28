package com.orange.artifact.dto;

import com.orange.artifact.model.Role;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private Role role;

}
