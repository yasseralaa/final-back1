package com.orange.artifact.validator;

import com.orange.artifact.dto.WeatherNoteDTO;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class WeatherNoteDTOValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return WeatherNoteDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        WeatherNoteDTO weatherNoteDTO = (WeatherNoteDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminID", "NotEmpty.weatherNoteDTO.adminID" , "adminID is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weatherDate", "NotEmpty.weatherNoteDTO.weatherDate", "weatherDate is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weatherNote", "NotEmpty.weatherNoteDTO.weatherNote", "weatherNote is required");

    }
}
