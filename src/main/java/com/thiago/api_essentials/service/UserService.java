package com.thiago.api_essentials.service;

import com.thiago.api_essentials.database.model.UserEntity;
import com.thiago.api_essentials.database.repository.UserRepository;
import com.thiago.api_essentials.dto.UserDTO;
import com.thiago.api_essentials.enums.Role;
import com.thiago.api_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserDTO userDTO){
        UserEntity novoUsuario = UserEntity.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(Role.ROLE_CLIENT)
                .build();
        return userRepository.save(novoUsuario);
    }

    public UserEntity updateUser(UserDTO userDTO, UUID id) throws NotFoundException {
        UserEntity usuario = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("usuario não encontrado"));
        usuario.setName(userDTO.getName());
        usuario.setEmail(userDTO.getEmail());
        usuario.setPassword(userDTO.getPassword());
        return userRepository.save(usuario);
    }

    public void deleteUser(UUID id) throws NotFoundException {
        if (!userRepository.existsById(id)){
            throw new NotFoundException("usuario não encontrado");
        }
        userRepository.deleteById(id);
    }
}
