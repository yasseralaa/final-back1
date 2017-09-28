package com.orange.artifact.dro;

import lombok.Data;

@Data
public class UserDRO {

    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private Integer roleId;

}
