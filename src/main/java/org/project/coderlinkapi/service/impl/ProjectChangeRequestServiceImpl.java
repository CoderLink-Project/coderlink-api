package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.model.entity.Project;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.RequestDTO;
import org.project.coderlinkapi.mapper.ProjectRequestMapper;
import org.project.coderlinkapi.repository.ProjectRequestRepository;
import org.project.coderlinkapi.service.ProjectChangeRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectChangeRequestServiceImpl implements ProjectChangeRequestService {

    private final ProjectRequestRepository projectRequestRepository;
    private final ProjectRequestMapper projectRequestMapper;


    public RequestDTO requestProjectChange(int projectId, RequestDTO requestDTO) {
        Project project = projectRequestRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        project.setMilestones(requestDTO.getMilestones());
        project.setDescription(requestDTO.getDescription());
        project.setStatus(requestDTO.getStatus());
        project.setUpdatedAt(requestDTO.getUpdatedAt());
        projectRequestRepository.save(project);
        return projectRequestMapper.toDTO(project);
    }

    public void deleteChangeRequest(int projectId) {
        Project project = projectRequestRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        project.setMilestones(null);
        project.setDescription(null);
        project.setStatus(null);
        projectRequestRepository.save(project);
    }

    public List<RequestDTO> getAllChangeRequests() {
        return projectRequestRepository.findAll().stream()
                .filter(project -> project.getMilestones() != null || project.getStatus() != null)
                .map(projectRequestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
