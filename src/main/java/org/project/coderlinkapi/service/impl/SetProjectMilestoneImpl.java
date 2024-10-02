package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.SetProjectMilestoneDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.ProjectMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.SetProjectMilestoneRepository;
import org.project.coderlinkapi.service.SetProjectMilestoneService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SetProjectMilestoneImpl implements SetProjectMilestoneService {

    private final SetProjectMilestoneRepository setProjectMilestoneRepository;
    private final ProjectMapper projectMapper;


    public SetProjectMilestoneDTO setProjectMilestone(int projectId, SetProjectMilestoneDTO setProjectMilestoneDTO) {
        Project existingProject = setProjectMilestoneRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        Project savedProject = setProjectMilestoneRepository.save(existingProject);
        return projectMapper.toDTO(savedProject);
    }

    public List<SetProjectMilestoneDTO> getMilestones(int projectId) {
        Project project = setProjectMilestoneRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        SetProjectMilestoneDTO SetProjectMilestoneDTO = projectMapper.toDTO(project);
        return Collections.singletonList(SetProjectMilestoneDTO);
    }

    public void delete(Integer id) {
        Project project = setProjectMilestoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        setProjectMilestoneRepository.delete(project);
    }

}

