package org.project.coderlinkapi.dto;

import lombok.Data;

@Data
public class FavoriteDeveloperResponseDTO {
    private Integer id;               // ID de la relación favorita
    private String customerName;      // Nombre completo del cliente
    private String developerName;     // Nombre completo del desarrollador marcado como favorito
    private String developerEmail;
    private String message;
}
