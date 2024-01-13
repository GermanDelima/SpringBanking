package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.Services.UserService;
import com.ar.cac.homebanking.models.dtos.UserDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    //creamos una instancia concreta de la clase UserService
@Autowired
private final UserService service;
public UserController(UserService service){

    this.service = service ;
}


    @GetMapping
    public void getUser(){} //obtenemos todos los user
    @GetMapping(value = "/{id}")
    public UserDTO getUserById(@PathVariable Long id){
    return null;
    } //obtenemos un user que se ingreso por la variable del path

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }

    public void updateAllUser(){} //modificamos completamente
    public void updateUser(){} //modificamos parcialmente
    public void deleteUser(){} //eliminamos
}
