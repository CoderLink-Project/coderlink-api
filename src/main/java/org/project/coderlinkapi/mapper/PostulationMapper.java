package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.PostulationRequestDTO;
import org.project.coderlinkapi.dto.PostulationResponseDTO;
import org.project.coderlinkapi.model.entity.Postulations;
import org.springframework.stereotype.Component;

@Component
public class PostulationMapper {
    private final ModelMapper modelMapper;

    public PostulationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar ModelMapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // Mapeo de Postulations a PostulationResponseDTO (para mostrar información completa)
    public PostulationResponseDTO toResponseDTO(Postulations postulations) {
        PostulationResponseDTO postulationResponseDTO = modelMapper.map(postulations, PostulationResponseDTO.class);

        // Mapear manualmente el id del desarrollador
        postulationResponseDTO.setDeveloperId(postulations.getDeveloper().getId());

        // Mapear manualmente el id del proyecto
        postulationResponseDTO.setPostulationId(postulations.getJobOffer().getId());

        return postulationResponseDTO;
    }

    // Mapeo de PostulationRequestDTO a Postulations (para crear una nueva postulación)
    public Postulations toEntity(PostulationRequestDTO postulationRequestDTO) {
        return modelMapper.map(postulationRequestDTO, Postulations.class);
    }
}
