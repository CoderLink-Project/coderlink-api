package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.RatingRequestDTO;
import org.project.coderlinkapi.dto.RatingResponseDTO;
import org.project.coderlinkapi.mapper.RatingMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private DeveloperRepository developerRepository;
    private RatingMapper ratingMapper;

    // Implementación del método para calificar a un desarrollador
    @Override
    public RatingResponseDTO rateDeveloper(Integer developerId, RatingRequestDTO ratingRequestDTO) {
        Optional<Developer> developerOptional = developerRepository.findById(developerId);

        if (developerOptional.isPresent()) {
            Developer developer = developerOptional.get();
            developer = ratingMapper.updateRatingFromDTO(developer, ratingRequestDTO);

            // Guardar la nueva calificación en la base de datos
            developerRepository.save(developer);

            return ratingMapper.toResponseDTO(developer);
        } else {
            throw new RuntimeException("El desarrollador con ID " + developerId + " no fue encontrado");
        }
    }

    // Implementación del método para obtener la calificación de un desarrollador
    @Override
    public RatingResponseDTO getDeveloperRating(Integer developerId) {
        Optional<Developer> developerOptional = developerRepository.findById(developerId);

        if (developerOptional.isPresent()) {
            return ratingMapper.toResponseDTO(developerOptional.get());
        } else {
            throw new RuntimeException("El desarrollador con ID " + developerId + " no fue encontrado");
        }
    }
}
