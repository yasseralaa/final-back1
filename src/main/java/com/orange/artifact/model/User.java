package com.orange.artifact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
@Component
public class User {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(name = "name")
    @NotNull
    private String name;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "password")
    private String password;

    @Getter @Setter
    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Getter @Setter
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
    private List<WeatherNote> weatherNotes;
}
