package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.dto.CheckHistoryCompletedDTO;
import org.project.coderlinkapi.exception.CheckHistoryCompletedNotFoundException;
import org.project.coderlinkapi.mapper.CheckHistoryCompletedMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.CheckHistoryCompletedRepository;
import org.project.coderlinkapi.service.CheckHistoryCompletedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CheckHistoryCompletedServiceImpl implements CheckHistoryCompletedService {


        private CheckHistoryCompletedRepository checkHistoryCompletedRepository;

        private CheckHistoryCompletedMapper checkHistoryCompletedMapper;

        @Override
        public List<CheckHistoryCompletedDTO> getCompletedProjectsByDeveloperId(Integer developerId) {
            // Obtener la lista de proyectos completados por el ID del desarrollador
            List<Project> completedProjects = checkHistoryCompletedRepository.findByDeveloperId(developerId);

            // Convertir la lista de entidades a DTOs y devolverla
            return completedProjects.stream()
                    .map(checkHistoryCompletedMapper::toDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public CheckHistoryCompletedDTO getCompletedProjectDetailsForDeveloper(Integer developerId, Integer projectId) {
            // Buscar el proyecto completado por su ID y verificar que pertenezca al desarrollador autenticado
            Project completedProject = checkHistoryCompletedRepository.findById(projectId)
                    .filter(project -> project.getDeveloper().getId() == developerId)  // Verificar si el proyecto pertenece al desarrollador
                    .orElseThrow(() -> new CheckHistoryCompletedNotFoundException("Proyecto no encontrado o no pertenece al desarrollador."));

            // Convertir y devolver el DTO
            return checkHistoryCompletedMapper.toDTO(completedProject);
        }
    }
