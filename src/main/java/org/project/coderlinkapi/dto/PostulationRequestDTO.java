package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PostulationRequestDTO {
    @NotNull(message = "El ID del desarrollador es obligatorio")
    private Integer developerId;

    @NotNull(message = "El ID de la oferta de trabajo es obligatoria")
    private Integer jobOfferId;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 50, message = "La descripcion debe tener 50 caracteres o menos")
    private String description;
}
