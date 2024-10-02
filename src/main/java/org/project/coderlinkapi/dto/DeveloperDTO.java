package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.project.coderlinkapi.model.entity.Skill;

@Data
public class DeveloperDTO {

    private Integer id;

    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Double rating; // Los hitos deben estar alineados con la calificación y rendimiento del desarrollador.

    @NotNull(message = "La habilidad es obligatoria")
    private Skill skill; // El desarrollador debe tener las habilidades adecuadas para asignar hitos relacionados con este proyecto.

    @Min(value = 0, message = "Las horas trabajadas no pueden ser negativas")
    private int hoursWorked; // El progreso en los hitos debe estar alineado con las horas trabajadas.

    @NotNull(message = "La tasa de pago es obligatoria")
    @DecimalMin(value = "0.0", inclusive = false, message = "La tasa de pago debe ser mayor que 0")
    private Double paymentRate; // Los hitos deben reflejar el nivel de contribución correspondiente a la tasa de pago.

    @Size(max = 65535, message = "La experiencia laboral es demasiado larga")
    private String workExperience; // Los hitos deben ajustarse a la experiencia profesional del desarrollador.

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private int yearsExperience; // Los hitos asignados deben coincidir con los años de experiencia del desarrollador.
}


