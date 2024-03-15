package com.ar.cac.homebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;


@Entity
@Table(name = "usuarios")
@Getter
@Setter


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
  private  Long Id;


    private String mail;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;

    private String dni;

}
