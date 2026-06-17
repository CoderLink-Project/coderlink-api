package org.project.coderlinkapi.service.impl;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectMonitorDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.ProjectMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.ProjectMonitorRepository;
import org.project.coderlinkapi.service.ProjectProgressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class ProjectProgressServiceImpl implements ProjectProgressService {

    private final ProjectMonitorRepository ProjectMonitorRepository;
    private final ProjectMapper projectMapper;


    public ProjectMonitorDTO updateProjectProgress(int projectId, ProjectMonitorDTO projectDetails) {
        Project project = ProjectMonitorRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setMilestones(projectDetails.getMilestones());
        project.setRevisions(projectDetails.getRevisions());
        project.setStatus(projectDetails.getStatus());
        project.setQualification(projectDetails.getQualification());
        project.setUpdatedAt(projectDetails.getUpdatedAt());
        Project updatedProject = ProjectMonitorRepository.save(project);

        return projectMapper.toDTO(updatedProject);
    }

    public ProjectMonitorDTO getProjectById(int projectId) {
        Project project = ProjectMonitorRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return projectMapper.toDTO(project);
    }

    public List<ProjectMonitorDTO> getAllProjects() {
        return ProjectMonitorRepository.findAll().stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }
}
