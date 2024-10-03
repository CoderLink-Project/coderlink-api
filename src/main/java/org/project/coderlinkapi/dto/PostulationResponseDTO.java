package org.project.coderlinkapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostulationResponseDTO {
    private int postulationId;
    private int developerId;
    private int jobOfferId;
    private String status;              // Estado de la postulación ("Pending", "Accepted", etc.)
    private LocalDateTime postulationDate;
    private String description;
}
