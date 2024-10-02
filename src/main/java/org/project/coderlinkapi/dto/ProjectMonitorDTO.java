package org.project.coderlinkapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProjectMonitorDTO {
    private String milestones;
    @NotBlank(message = "Los hitos del proyecto son obligatorios para monitorear el progreso.")

    private String status;
    @NotBlank(message = "El estado del proyecto es obligatorio para saber su avance.")

    private LocalDateTime updatedAt;
    @NotBlank(message = "La fecha de actualización es obligatoria para monitorear los cambios recientes.")

    private int revisions;
    @NotBlank(message = "El número de revisiones debe ser igual o mayor a cero.")

    private BigDecimal qualification;

}