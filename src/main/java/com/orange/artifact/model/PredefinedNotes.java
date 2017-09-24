package com.orange.artifact.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "predefinedNotes")
public class PredefinedNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "minimumTemprature")
    private Integer minimumTemprature;
    @Column(name = "maximumTemperature")
    private Integer maximumTemperature;
    @Column(name = "message")
    private String message;
}
