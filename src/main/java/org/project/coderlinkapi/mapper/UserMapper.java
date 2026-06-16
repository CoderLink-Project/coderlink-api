package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.AuthResponseDTO;
import org.project.coderlinkapi.dto.LoginDTO;
import org.project.coderlinkapi.dto.UserProfileDTO;
import org.project.coderlinkapi.dto.UserRegistrationDTO;
import org.project.coderlinkapi.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Convertir de UserRegistrationDTO a User (solo mapeo directo)
    public User toUserEntity(UserRegistrationDTO registrationDTO) {
        return modelMapper.map(registrationDTO, User.class);
    }

    // Convertir de User a UserProfileDTO para la respuesta
    public UserProfileDTO toUserProfileDTO(User user) {
        UserProfileDTO userProfileDTO = modelMapper.map(user, UserProfileDTO.class);

        // Si es cliente, asignar los datos de cliente
        if (user.getCustomer() != null) {
            userProfileDTO.setFirstName(user.getCustomer().getFirstname());
            userProfileDTO.setLastName(user.getCustomer().getLastname());
            userProfileDTO.setDescription(user.getCustomer().getDescription());
            if (user.getCustomer().getProjects() != null) {
                userProfileDTO.setProjects(user.getCustomer().getProjects());
            } else {
                userProfileDTO.setProjects(new ArrayList<>()); // Inicializar como lista vacía si es nula
            }

        }
        // Si es desarrollador, asignar los datos de desarrollador
        if (user.getDeveloper() != null) {
            userProfileDTO.setFirstName(user.getDeveloper().getFirstName());
            userProfileDTO.setLastName(user.getDeveloper().getLastName());
            userProfileDTO.setDescription(user.getDeveloper().getDescription());
            userProfileDTO.setRating(user.getDeveloper().getRating());
            userProfileDTO.setPaymentRate(user.getDeveloper().getPaymentRate());
            userProfileDTO.setPortafolio(userProfileDTO.getPortafolio());
            userProfileDTO.setSkill(userProfileDTO.getSkill());
        }

        return userProfileDTO;
    }

    // Convertir de LoginDTO a User (cuando procesas el login)
    public User toUserEntity(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, User.class);
    }

    // Convertir de User a AuthResponseDTO para la respuesta de autenticación
    public AuthResponseDTO toAuthResponseDTO(User user, String token) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token); // Asignar el token


        // Si es cliente, asignar los datos de cliente
        if (user.getCustomer() != null) {
            authResponseDTO.setFirstName(user.getCustomer().getFirstname());
            authResponseDTO.setLastName(user.getCustomer().getLastname());
        }
        // Si es desarrollador, asignar los datos de autor
        else if (user.getDeveloper() != null) {
            authResponseDTO.setFirstName(user.getDeveloper().getFirstName());
            authResponseDTO.setLastName(user.getDeveloper().getLastName());
        }
        // Para cualquier usuario que no sea cliente ni autor (ej. Admin)
        else {
            authResponseDTO.setFirstName("Admin");
            authResponseDTO.setLastName("User");
        }

        // Asignar el rol del usuario
        authResponseDTO.setRole(user.getRole().getName().toString());

        return authResponseDTO;
    }
}
