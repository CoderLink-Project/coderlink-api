package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class JobOfferCreateEditDTO {
    private Integer id;
    @NotBlank(message = "El titulo es obligatorio")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El presupuesto es obligatorio")
    @Positive(message = "El presupuesto debe ser un valor positivo")
    private Double budget;

    @NotNull(message = "El tiempo de duracion es obligatorio")
    private int duration;

    @NotNull(message = "El Id del Cliente es obligatorio")
    private int customerId;

    @NotNull(message = "El Id del Proyecto es obligatorio")
    private int projectId;
}

