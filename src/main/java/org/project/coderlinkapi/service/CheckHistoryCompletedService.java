package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.CheckHistoryCompletedDTO;

import java.util.List;

public interface CheckHistoryCompletedService {

    //Obtener historial de proyectos completados de un desarrollador por su ID
    List<CheckHistoryCompletedDTO> getCompletedProjectsByDeveloperId(Integer developerId);

    //obtener los detalles de un proyecto completado
    CheckHistoryCompletedDTO getCompletedProjectDetailsForDeveloper(Integer developerId, Integer projectId);
}
