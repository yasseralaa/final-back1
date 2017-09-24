package com.orange.artifact.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private Integer roleId;

}
