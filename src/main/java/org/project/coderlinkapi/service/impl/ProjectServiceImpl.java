package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.ProjectMapper;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.repository.ProjectRepository;
import org.project.coderlinkapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final CustomerRepository customerRepository;
    private final DeveloperRepository developerRepository;
    private final ProjectMapper projectMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ProjectDTO> getAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProjectDTO> paginate(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects.map(projectMapper::toDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public ProjectDTO findById(Integer id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proyecto con ID " + id + " no fue encontrado"));
        return projectMapper.toDTO(project);
    }

    @Transactional
    @Override
    public ProjectDTO create(ProjectDTO projectDTO) {
        Customer customer = customerRepository.findById(projectDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Developer developer = developerRepository.findById(projectDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Desarrollador no encontrado"));

        Project project = projectMapper.toEntity(projectDTO, customer, developer);
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        project = projectRepository.save(project);

        return projectMapper.toDTO(project);
    }


    @Transactional
    @Override
    public ProjectDTO update(Integer id, ProjectDTO projectDTO) {
        Project projectFromDb = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proyecto con ID " + id + " no fue encontrado"));

        projectFromDb.setName(projectDTO.getName());
        projectFromDb.setDescription(projectDTO.getDescription());
        projectFromDb.setMilestones(projectDTO.getMilestones());
        projectFromDb.setStatus(projectDTO.getStatus());
        projectFromDb.setCategoryProject(projectDTO.getCategoryProject());
        projectFromDb.setQualification(projectDTO.getQualification());
        projectFromDb.setUpdatedAt(LocalDateTime.now());

        projectFromDb = projectRepository.save(projectFromDb);
        return projectMapper.toDTO(projectFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proyecto con ID " + id + " no fue encontrado"));
        projectRepository.delete(project);
    }
}
