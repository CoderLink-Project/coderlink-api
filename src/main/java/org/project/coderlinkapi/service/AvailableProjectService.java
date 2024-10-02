package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.ProjectDTO;

import java.util.List;

public interface AvailableProjectService {
    List<ProjectDTO> getAvailableProjects();
}