package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.ProjectRepository;
import org.project.coderlinkapi.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> searchProjects(String keyword) {
        return projectRepository.findByNameContainingOrDescriptionContaining(keyword, keyword);
    }
    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}
