package com.ar.cac.homebanking.Services;


import com.ar.cac.homebanking.Repositories.UserRepository;
import com.ar.cac.homebanking.mappers.UserMapper;
import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    public UserRepository repository;

    //metodos

    public UserDTO createUser(UserDTO userDto){
        //Mapeamos un UserDTO a Entity
        User user = repository.save(UserMapper.dtoToUser(userDto));
        //Mapeamos la Entity  a un UserDTO
        return    UserMapper.userToDto(user);
}

}
