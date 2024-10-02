package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.mapper.ModifyProjectMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.ModifyProject;
import org.project.coderlinkapi.service.ModifyProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ModifyProjectService {

    private final ModifyProject modifyProject;

    @Override
    @Transactional
    public ProjectDTO updateProject(Integer projectId, Integer customerId, ProjectDTO projectDTO) {
        Optional<Project> optionalProject = modifyProject.findByIdAndCustomerId(projectId, customerId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project = ModifyProjectMapper.toEntity(projectDTO, project);
            modifyProject.save(project);
            return ModifyProjectMapper.toDto(project);
        } else {
            throw new RuntimeException("Project not found or customer is not the owner");
        }
    }
}
