package org.project.coderlinkapi.dto;

import lombok.Data;

@Data
public class RatingResponseDTO {
    private Integer developerId;
    private String firstName;
    private String lastName;
    private Double rating;  // Calificación en estrellas (1-5)
}