package com.ar.cac.homebanking.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

   private Long id;
   private String mail;
   private String password;
   private String name;
   private String surname;
   private String dni;



}
