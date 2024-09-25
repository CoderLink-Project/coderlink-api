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
    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setName(updatedProject.getName());
            existingProject.setDescription(updatedProject.getDescription());
            existingProject.setMilestones(updatedProject.getMilestones());
            existingProject.setPresentation(updatedProject.getPresentation());
            return projectRepository.save(existingProject);
        }).orElse(null);
    }
    @Override
    public List<Project> getAvailableProjects() {
        return projectRepository.findByStatus("Available");
    }
}
