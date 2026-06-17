package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDeveloperRateDTO {

    @NotNull(message = "El ID del desarrollador es obligatorio")
    private Integer developerId;

    @DecimalMin(value = "0.0", inclusive = false, message = "La tarifa debe ser mayor que 0")
    private Double newPaymentRate;  // Nueva tarifa del desarrollador
}
