package org.project.coderlinkapi.service;

import org.project.coderlinkapi.model.dto.UserRequestDTO;
import org.project.coderlinkapi.model.dto.UserResponseDTO;
import org.project.coderlinkapi.model.entity.User;
import org.project.coderlinkapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Crear un nuevo usuario
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new RuntimeException("El email ya está registrado.");
        }

        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPass()); // Considera encriptar la contraseña
        user.setCreateAt(LocalDate.now()); // Asigna la fecha actual
        user.setUpdatedAt(LocalDate.now()); // Asigna la fecha actual
        user.setRole(userRequestDTO.getRole());

        user = userRepository.save(user);

        return new UserResponseDTO(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdatedAt(),
                user.getRole()
        );
    }

    // Actualizar un usuario existente
    public UserResponseDTO updateUser(Long id, UserRequestDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado.");
        }

        User user = optionalUser.get();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPass()); // Considera encriptar la contraseña
        user.setUpdatedAt(LocalDate.now()); // Actualiza la fecha
        user.setRole(userDTO.getRole());

        user = userRepository.save(user);

        return new UserResponseDTO(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdatedAt(),
                user.getRole()
        );
    }

    // Obtener un usuario por ID
    public UserResponseDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado.");
        }

        User user = optionalUser.get();
        return new UserResponseDTO(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdatedAt(),
                user.getRole()
        );
    }

    // Verificar si existe un usuario con email o id
    public boolean existsByEmailOrId(String email, Long id) {
        return userRepository.existsByEmailOrId(email, id);
    }

    // Verificar si existe un usuario con email
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Verificar si existe un usuario con email y contraseña
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }
}


