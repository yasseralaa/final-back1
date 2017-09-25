package com.orange.artifact.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "predefinedNotes")
public class PredefinedNotes {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(name = "minimumTemprature")
    private Integer minimumTemprature;

    @Getter @Setter
    @Column(name = "maximumTemperature")
    private Integer maximumTemperature;

    @Getter @Setter
    @Column(name = "message")
    private String message;
}
