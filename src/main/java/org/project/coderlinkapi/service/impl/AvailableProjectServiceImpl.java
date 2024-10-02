package org.project.coderlinkapi.service.impl;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.mapper.ProjectMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.AvailableProjectRepository;
import org.project.coderlinkapi.service.AvailableProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AvailableProjectServiceImpl implements AvailableProjectService {

    private final AvailableProjectRepository availableProjectRepository;

    public List<ProjectDTO> getAvailableProjects() {
        List<Project> availableProjects = availableProjectRepository.findByDeveloperIsNull();
        return availableProjects.stream()
                .map(ProjectMapper::toDto)
                .collect(Collectors.toList());
    }
}
