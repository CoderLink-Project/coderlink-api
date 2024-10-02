package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.ProjectDTO;

public interface ModifyProjectService {
    ProjectDTO updateProject(Integer projectId, Integer customerId, ProjectDTO projectDTO);
}
