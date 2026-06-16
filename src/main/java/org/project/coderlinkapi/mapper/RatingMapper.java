package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.RatingRequestDTO;
import org.project.coderlinkapi.dto.RatingResponseDTO;
import org.project.coderlinkapi.model.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {

    private final ModelMapper modelMapper;

    public RatingMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar ModelMapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // Mapeo de Developer a RatingResponseDTO (para mostrar la calificación de un desarrollador)
    public RatingResponseDTO toResponseDTO(Developer developer) {
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();

        // Mapear manualmente los campos necesarios
        ratingResponseDTO.setDeveloperId(developer.getId());
        ratingResponseDTO.setFirstName(developer.getFirstName());
        ratingResponseDTO.setLastName(developer.getLastName());
        ratingResponseDTO.setRating(developer.getRating());

        return ratingResponseDTO;
    }

    // Mapeo de RatingRequestDTO a Developer (para actualizar la calificación de un desarrollador)
    public Developer updateRatingFromDTO(Developer developer, RatingRequestDTO ratingRequestDTO) {
        // Actualizar la calificación del desarrollador
        developer.setRating(ratingRequestDTO.getRating());

        return developer;
    }
}

