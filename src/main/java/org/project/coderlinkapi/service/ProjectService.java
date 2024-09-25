package org.project.coderlinkapi.service;

import org.project.coderlinkapi.model.entity.Project;
import java.util.List;

public interface ProjectService {
    Project updateProject(Long id, Project updatedProject);
    List<Project> getAvailableProjects();
}
