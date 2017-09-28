package com.orange.artifact.dro;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


public class LoginDRO {

    @Getter @Setter
    @NotNull
    private String email;

    @Getter @Setter
    @NotNull
    private String password;
}
