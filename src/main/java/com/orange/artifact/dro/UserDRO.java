package com.orange.artifact.dro;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class UserDRO {

    @Getter @Setter
    @NotNull
    private String name;

    @Getter @Setter
    @NotNull
    private String email;

    @Getter @Setter
    @NotNull
    private String password;

    @Getter @Setter
    @NotNull
    private String mobileNumber;

    @Getter @Setter
    @NotNull
    private Integer roleId;

}
