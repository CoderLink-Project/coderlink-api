package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RequestDTO {
    private int id;

    @NotBlank(message = "El nombre del proyecto es obligatorio.")
    private String name;
    @NotBlank(message = "Los hitos del proyecto son obligatorios.")
    private String milestones;
    @NotBlank(message = "La descripción es obligatoria y debe contener entre 10 y 500 caracteres.")
    private String description;
    @NotBlank(message = "El estado del proyecto es obligatorio.")
    private String status;
    @NotBlank(message = "La fecha de actualización es obligatoria.")
    private LocalDateTime updatedAt;

}

