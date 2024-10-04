package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.AuthResponseDTO;
import org.project.coderlinkapi.dto.UserProfileDTO;
import org.project.coderlinkapi.dto.UserRegistrationDTO;
import org.project.coderlinkapi.dto.LoginDTO;

public interface UserService {
    // Registrar un cliente
    UserProfileDTO registerCustomer(UserRegistrationDTO registrationDTO);

    // Registrar un developer
    UserProfileDTO registerDeveloper(UserRegistrationDTO registrationDTO);

    // Autenticar usuario (login)
    AuthResponseDTO login(LoginDTO loginDTO);


    // Actualizar el perfil de usuario
    UserProfileDTO updateUserProfile(Integer id, UserProfileDTO userProfileDTO);

    // Obtener el perfil de usuario por ID
    UserProfileDTO getUserProfileById(Integer id);
}

