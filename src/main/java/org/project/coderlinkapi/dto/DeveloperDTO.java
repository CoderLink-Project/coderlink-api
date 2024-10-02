package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.project.coderlinkapi.model.entity.Skill;
@Data
public class DeveloperDTO {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String firstName;

    @NotNull(message = "La habilidad es obligatoria")
    private Skill skill;

    @Min(value = 0, message = "Las horas trabajadas no pueden ser negativas")
    private int hoursWorked;

    @NotNull(message = "La tasa de pago es obligatoria")
    @DecimalMin(value = "0.0", inclusive = false, message = "La tasa de pago debe ser mayor que 0")
    private Double paymentRate;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private int yearsExperience;
}



