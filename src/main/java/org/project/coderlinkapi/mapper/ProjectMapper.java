package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.model.entity.Project;

public class ProjectMapper {

    public static ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setQualification(project.getQualification());
        dto.setCategoryProject(project.getCategoryProject());
        return dto;
    }
}
