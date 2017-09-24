package com.orange.artifact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobileNumber")
    private String mobileNumber;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;
    @OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
    private List<WeatherNote> weatherNotes;
}
