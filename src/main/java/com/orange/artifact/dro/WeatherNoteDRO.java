package com.orange.artifact.dro;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

public class WeatherNoteDRO {

    @Getter
    @Setter
    @NotBlank(message = "adminID can't be blank")
    @NotEmpty(message = "adminID can't be empty")
    private Integer id;

    @Getter
    @Setter
    @NotBlank(message = "weatherDate can't be blank")
    @NotEmpty(message = "weatherDate can't be empty")
    private Date date;


    @Getter
    @Setter
    @NotBlank(message = "weatherNote can't be blank")
    @NotEmpty(message = "weatherNote can't be empty")
    private String note;
}
