package com.orange.artifact.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class PredifinedNoteDTO {


    private Integer id;


    private Integer minimumTemprature;


    private Integer maximumTemperature;


    private String message;
}
