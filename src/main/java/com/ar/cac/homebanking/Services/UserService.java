package com.ar.cac.homebanking.Services;


import com.ar.cac.homebanking.Repositories.UserRepository;
import com.ar.cac.homebanking.exceptions.UserNotExistsException;
import com.ar.cac.homebanking.mappers.UserMapper;
import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    public UserRepository repository;

    //método para traer una lista de users del repository y guardarlo en una lista de users
    //para después pasar esa lista de user a usersDtos con programación funcional
    public List<UserDTO> getUsers() {
        List<User> users = repository.findAll();
        List<UserDTO> usersDtos = users.stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
        return usersDtos;

    }

    //método para pasar un userDto a una entity y devolverla
    public UserDTO createUser(UserDTO userDto) {
        //Mapeamos un UserDTO ha Entity
        User user = repository.save(UserMapper.dtoToUser(userDto));
        //Mapeamos la Entity  a un UserDTO
        return UserMapper.userToDto(user);
    }

    //método para traer un user por id
    public UserDTO getUsersById(Long id) {
        User entity = repository.findById(id).get();
        return UserMapper.userToDto(entity);
    }

    //método para eliminar un user en caso de que exista
    //si no devuelve una exception
    public String deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "El usuario con el id: " + id + " se elimino";
        } else {
            throw new UserNotExistsException("El usuario a eliminar elegido no existe");
        }
    }
}





