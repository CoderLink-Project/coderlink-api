package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.PostulationRequestDTO;
import org.project.coderlinkapi.dto.PostulationResponseDTO;

public interface PostulationService {
    PostulationResponseDTO applyToJob(PostulationRequestDTO postulationsDTO);
}
