package com.orange.artifact.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import java.sql.Date;

public class WeatherNoteDTO {
    @NotBlank(message = "adminID can't be blank")
    @NotEmpty(message = "adminID can't be empty")
    private Integer adminID;

    @NotBlank(message = "weatherDate can't be blank")
    @NotEmpty(message = "weatherDate can't be empty")
    private Date weatherDate;


    @NotBlank(message = "weatherNote can't be blank")
    @NotEmpty(message = "weatherNote can't be empty")
    private String weatherNote;
}
