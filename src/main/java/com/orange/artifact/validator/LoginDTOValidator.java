package com.orange.artifact.validator;

import com.orange.artifact.dto.LoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LoginDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginDTO loginDTO = (LoginDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.loginDTO.email", "email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginDTO.password", "password is required");
    }

}
