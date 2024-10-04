package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RatingRequestDTO {
    @Min(1)  // Calificación mínima de 1 estrella
    @Max(5)  // Calificación máxima de 5 estrellas
    private Double rating;
}

