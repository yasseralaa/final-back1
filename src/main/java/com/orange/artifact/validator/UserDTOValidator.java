package com.orange.artifact.validator;

import com.orange.artifact.dto.UserDTO;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserDTOValidator implements Validator{



    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userDTO.name" , "name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userDTO.email", "email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userDTO.password", "password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty.userDTO.mobileNumber", "mobile number is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleId", "NotEmpty.userDTO.roleId", "roleId is required");

    }
}
