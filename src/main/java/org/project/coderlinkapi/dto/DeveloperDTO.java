package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.project.coderlinkapi.model.entity.Skill;

import java.time.LocalDateTime;

@Data
public class DeveloperDTO {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede tener más de 50 caracteres")
    private String lastName;

    @Size(max = 65535, message = "La descripción es demasiado larga")
    private String description;

    @Size(max = 65535, message = "El portafolio es demasiado largo")
    private String portfolio;

    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Double rating;

    @NotNull(message = "La habilidad es obligatoria")
    private Skill skill; // Para referenciar la entidad Skill mediante su id

    @Min(value = 0, message = "Las horas trabajadas no pueden ser negativas")
    private int hoursWorked;

    @NotNull(message = "La tasa de pago es obligatoria")
    @DecimalMin(value = "0.0", inclusive = false, message = "La tasa de pago debe ser mayor que 0")
    private Double paymentRate;

    @Size(max = 65535, message = "La experiencia laboral es demasiado larga")
    private String workExperience;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private int yearsExperience;

}
