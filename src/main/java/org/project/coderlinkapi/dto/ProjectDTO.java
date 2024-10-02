package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProjectDTO {
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotBlank(message = "Los hitos son obligatorios")
    private String milestones;

    @NotBlank(message = "La presentación es obligatoria")
    private String presentation;

    @Min(value = 0, message = "Las revisiones deben ser al menos 0")
    private int revisions;

    @NotBlank(message = "El estado es obligatorio")
    private String status;

    @NotBlank(message = "La categoría del proyecto es obligatoria")
    private String categoryProject;

    @DecimalMin(value = "0.0", inclusive = false, message = "La calificación debe ser mayor que 0")
    private BigDecimal qualification;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull(message = "El Id del Cliente es obligatorio")
    private Integer customerId;

    private Integer developerId;
}
