package com.ar.cac.homebanking.mappers;


import com.ar.cac.homebanking.models.User;

import com.ar.cac.homebanking.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    //Metodos para pasar de UserDTO a Entity y guardar en el Repository base de datospublic static User dtoToUser(UserDTO dto){
    public static User dtoToUser(UserDTO dto) {
        User user = new User();
        user.setMail(dto.getMail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setDni(dto.getDni());
        //user.setId(user.getId());
        return user;
    }

    //Metodo para pasar de Entity a DTO y mostrale al usuario
    public static UserDTO userToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setMail(user.getMail());
        dto.setPassword(user.getPassword());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setDni(user.getDni());
        dto.setId(user.getId());
        return dto;
    }




}
