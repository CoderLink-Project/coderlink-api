package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.model.entity.Project;

import java.time.LocalDateTime;

public class ModifyProjectMapper {

    public static ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setMilestones(project.getMilestones());
        dto.setPresentation(project.getPresentation());
        dto.setRevisions(project.getRevisions());
        dto.setStatus(project.getStatus());
        dto.setCategoryProject(project.getCategoryProject());
        dto.setQualification(project.getQualification());
        dto.setCustomerId(project.getCustomer().getId());
        if (project.getDeveloper() != null) {
            dto.setDeveloperId(project.getDeveloper().getId());
        }
        return dto;
    }

    public static Project toEntity(ProjectDTO dto, Project project) {
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setMilestones(dto.getMilestones());
        project.setPresentation(dto.getPresentation());
        project.setRevisions(dto.getRevisions());
        project.setStatus(dto.getStatus());
        project.setCategoryProject(dto.getCategoryProject());
        project.setQualification(dto.getQualification());
        project.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now());
        return project;
    }
}
