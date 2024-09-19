package org.project.coderlinkapi.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.coderlinkapi.model.enums.Role;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotNull(message = "El nombre no puede ser vacio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String userName;

    @NotBlank(message = "El correo electronico no puede ser vacío")
    @Email(message = "La dirección de correo electrónico debe ser correcta")
    @Size(max = 100, message = "El correo electrónico no puede exceder los 100 caracteres")
    private String email;

    @NotBlank(message = "La contraseña no puede ir vacia")
    @Size(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres")
    private String pass;

    private LocalDate createAt;
    private LocalDate updatedAt;

    @NotBlank
    private Role role;
}
