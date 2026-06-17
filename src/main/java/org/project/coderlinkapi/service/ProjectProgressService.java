package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.ProjectMonitorDTO;

import java.util.List;

public interface ProjectProgressService {
    ProjectMonitorDTO updateProjectProgress(int projectId, ProjectMonitorDTO projectDetails);

    ProjectMonitorDTO getProjectById(int projectId);

    List<ProjectMonitorDTO> getAllProjects();



}
