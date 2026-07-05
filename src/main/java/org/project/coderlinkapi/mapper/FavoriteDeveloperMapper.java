package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.FavoriteDeveloperResponseDTO;
import org.project.coderlinkapi.model.entity.FavoriteDevelopers;
import org.springframework.stereotype.Component;

@Component
public class FavoriteDeveloperMapper {

    // Mapea de entidad a DTO de respuesta
    public FavoriteDeveloperResponseDTO toResponseDTO(FavoriteDevelopers favoriteDevelopers) {
        FavoriteDeveloperResponseDTO responseDTO = new FavoriteDeveloperResponseDTO();
        responseDTO.setId(favoriteDevelopers.getId());

        // Mapeamos el nombre y el email del desarrollador
        responseDTO.setDeveloperName(favoriteDevelopers.getDeveloper().getFirstName() + " " + favoriteDevelopers.getDeveloper().getLastName());
        responseDTO.setDeveloperEmail(favoriteDevelopers.getDeveloper().getEmail());

        // Mensaje de confirmación
        responseDTO.setMessage("Desarrolador añadido a favoritos");

        return responseDTO;
    }
}