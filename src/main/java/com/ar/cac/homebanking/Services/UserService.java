package com.ar.cac.homebanking.Services;


import com.ar.cac.homebanking.Repositories.UserRepository;
import com.ar.cac.homebanking.exceptions.UserNotExistsException;
import com.ar.cac.homebanking.mappers.UserMapper;
import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

        User userValidated = validateUserByMail(userDto); //valida user por mail
        if (userValidated == null){
            //Si el mail del user es == null quiere decir que no existe, X ende lo guardamos en la data base usando el Mappers
            User userSave = repository.save(UserMapper.dtoToUser(userDto));
            //Mapeamos la Entity a un UserDTO y lo retornamos al controller
            return UserMapper.userToDto(userSave);
        } else {
           throw  new UserNotExistsException("Usuario con mail" + userDto.getMail() + " Existe" );
        }

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
    //metodo para editar completamente
    public UserDTO editUser(Long id, UserDTO dto) {
        if (repository.existsById(id)){
           User userToModify =  repository.findById(id).get();
           if (dto.getDni() != null){
               userToModify.setDni(dto.getDni());
           }
           if (dto.getName() != null){
               userToModify.setName(dto.getName());
           }
           if (dto.getPassword() != null){
               userToModify.setPassword(dto.getPassword());
           }
           if (dto.getMail() != null){
               userToModify.setMail(dto.getMail());
           }
           repository.save(userToModify);
           return UserMapper.userToDto(userToModify);

        }
        return null;
    }

    //validamo si existe un user por su email en base de datos True o False
    public User validateUserByMail(UserDTO dto){
        return  repository.findByMail(dto.getMail());
    }
}





