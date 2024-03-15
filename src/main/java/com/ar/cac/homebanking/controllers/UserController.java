package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.Services.UserService;
import com.ar.cac.homebanking.models.dtos.UserDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    //creamos una instancia concreta de la clase UserService
@Autowired
private final UserService service;
public UserController(UserService service){

    this.service = service ;
}

    //obtenemos una lista de user
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
    List<UserDTO> lista = service.getUsers();
    return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    //obtenemos un user que se ingreso por la variable del path
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(service.getUsersById(id));
    }

    //creamos un Users
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }
    //modification total a todos los user y a uno solo
    //necesitamos pasar él id del usuario
    //necesitamos pasar el campo a ser modificado

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> editUser(@PathVariable Long id,  @RequestBody UserDTO dto){
    return ResponseEntity.status(HttpStatus.OK).body(service.editUser(id, dto));
    }


    //eliminamos un user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }






}
