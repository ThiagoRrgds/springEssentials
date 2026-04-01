package com.thiago.api_essentials.controller;

import com.thiago.api_essentials.database.model.UserEntity;
import com.thiago.api_essentials.dto.UserDTO;
import com.thiago.api_essentials.exception.NotFoundException;
import com.thiago.api_essentials.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserDTO userDTO){
        UserEntity usuario = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
