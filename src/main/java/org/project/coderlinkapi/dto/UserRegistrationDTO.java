package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.project.coderlinkapi.model.entity.Skill;

@Data
public class UserRegistrationDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Email(message = "El correo electrónico no es válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;

    @NotNull(message = "La contraseña es obligatoria")
    @Size(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;

    // Campos específicos para Cliente

    // Campos específicos para Developer
    private String description;
    private Skill skill;
    private String portafolio;
    private String workExperience;
    private Double paymentRate;


}
