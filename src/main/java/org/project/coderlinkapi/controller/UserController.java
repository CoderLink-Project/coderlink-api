package org.project.coderlinkapi.controller;

import jakarta.validation.Valid;
import org.project.coderlinkapi.model.dto.UserRequestDTO;
import org.project.coderlinkapi.model.dto.UserResponseDTO;
import org.project.coderlinkapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable("id") Long id,
            @Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(id, userRequestDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Verificar si existe un usuario con email o id
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByEmailOrId(
            @RequestParam("email") String email,
            @RequestParam("id") Long id) {
        boolean exists = userService.existsByEmailOrId(email, id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Verificar si existe un usuario con email
    @GetMapping("/exists/email")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam("email") String email) {
        boolean exists = userService.existsByEmail(email);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Verificar si existe un usuario con email y contraseña
    @GetMapping("/exists/credentials")
    public ResponseEntity<Boolean> existsByEmailAndPassword(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        boolean exists = userService.existsByEmailAndPassword(email, password);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
