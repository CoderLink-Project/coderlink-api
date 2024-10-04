package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.RatingRequestDTO;
import org.project.coderlinkapi.dto.RatingResponseDTO;

public interface RatingService {

    // Método para calificar a un desarrollador
    RatingResponseDTO rateDeveloper(Integer developerId, RatingRequestDTO ratingRequestDTO);

    // Método para obtener la calificación de un desarrollador por su ID
    RatingResponseDTO getDeveloperRating(Integer developerId);
}
