package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    // Convertir de Entity a DTO
    public ProjectDTO toDTO(Project project) {
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
        dto.setCreatedAt(project.getCreatedAt());
        dto.setUpdatedAt(project.getUpdatedAt());

        // Asignar IDs de relaciones
        if (project.getCustomer() != null) {
            dto.setCustomerId(project.getCustomer().getId());
        }
        if (project.getDeveloper() != null) {
            dto.setDeveloperId(project.getDeveloper().getId());
        }

        return dto;
    }

    // Convertir de DTO a Entity
    public Project toEntity(ProjectDTO dto, Customer customer, Developer developer) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setMilestones(dto.getMilestones());
        project.setPresentation(dto.getPresentation());
        project.setRevisions(dto.getRevisions());
        project.setStatus(dto.getStatus());
        project.setCategoryProject(dto.getCategoryProject());
        project.setQualification(dto.getQualification());
        project.setCreatedAt(dto.getCreatedAt());
        project.setUpdatedAt(dto.getUpdatedAt());

        // Asignar relaciones
        project.setCustomer(customer);
        project.setDeveloper(developer);

        return project;
    }
}
