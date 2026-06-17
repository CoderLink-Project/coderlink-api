package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAll();
    Page<ProjectDTO> paginate(Pageable pageable);
    ProjectDTO findById(Integer id);
    ProjectDTO create(ProjectDTO projectDTO);
    ProjectDTO update(Integer id, ProjectDTO updateProjectDTO);
    void delete(Integer id);
}