package com.orange.artifact.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import java.sql.Date;
@Data
public class WeatherNoteDTO {


    private Integer id;

    private Date date;


    private String note;
}
