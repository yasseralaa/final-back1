package com.orange.artifact.dro;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@Validated
public class LoginDRO {
    private String email;
    private String password;
}
