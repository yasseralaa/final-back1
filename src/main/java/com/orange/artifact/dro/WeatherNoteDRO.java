package com.orange.artifact.dro;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class WeatherNoteDRO {

    @Getter @Setter
    @NotNull
    private Integer id;

    @Getter @Setter
    @NotNull
    private Date date;


    @Getter @Setter
    @NotNull
    private String note;
}
