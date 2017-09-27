package com.orange.artifact.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

public class PredifinedNoteDto {
    @Getter
    @Setter
    @NotBlank(message = "predifined note id can't be blank")
    @NotEmpty(message = "predifined note id can't be empty")
    private Integer id;

    @Getter @Setter
    @NotBlank(message = "minimumTemprature can't be blank")
    @NotEmpty(message = "minimumTemprature  can't be empty")
    private Integer minimumTemprature;

    @Getter @Setter
    @NotBlank(message = "maximumTemperature can't be blank")
    @NotEmpty(message = "maximumTemperature can't be empty")
    private Integer maximumTemperature;

    @Getter @Setter
    @NotBlank(message = "message can't be blank")
    @NotEmpty(message = "message can't be empty")
    private String message;
}
