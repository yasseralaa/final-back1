package com.orange.artifact.dro;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class PredifinedNoteDRO {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer minimumTemprature;

    @Getter @Setter
    private Integer maximumTemperature;

    @Getter @Setter
    private String message;
}
