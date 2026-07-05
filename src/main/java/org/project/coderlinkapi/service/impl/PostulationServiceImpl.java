package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;

import org.project.coderlinkapi.dto.PostulationRequestDTO;
import org.project.coderlinkapi.dto.PostulationResponseDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.PostulationMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.project.coderlinkapi.model.entity.Postulations;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.repository.JobOfferRepository;
import org.project.coderlinkapi.repository.PostulationRepository;
import org.project.coderlinkapi.service.PostulationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PostulationServiceImpl implements PostulationService {

    private PostulationRepository postulationsRepository;
    private DeveloperRepository developerRepository;
    private JobOfferRepository jobOfferRepository;
    private PostulationMapper postulationsMapper;

    @Override
    public PostulationResponseDTO applyToJob(PostulationRequestDTO postulationsDTO) {
        // Obtener el desarrollador y la oferta de trabajo
        Developer developer = developerRepository.findById(postulationsDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Desarrollador no encontrado con ID: " + postulationsDTO.getDeveloperId()));

        JobOffer jobOffer = jobOfferRepository.findById(postulationsDTO.getJobOfferId())
                .orElseThrow(() -> new ResourceNotFoundException("Oferta de trabajo no encontrado con ID: " + postulationsDTO.getJobOfferId()));

        // Crear la entidad Postulation
        Postulations postulation = new Postulations();
        postulation.setDeveloper(developer);
        postulation.setJobOffer(jobOffer);
        postulation.setStatus("Pending");
        postulation.setPostulationDate(LocalDateTime.now());
        postulation.setDescription(postulationsDTO.getDescription());

        // Guardar la postulación
        Postulations savedPostulation = postulationsRepository.save(postulation);

        // Retornar el DTO de la postulación guardada
        return postulationsMapper.toResponseDTO(savedPostulation);
    }
}
