package org.project.coderlinkapi.service;

import org.project.coderlinkapi.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> searchProjects(String keyword);
    void deleteProject(Long id);
}
