package org.project.coderlinkapi.controller;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectMonitorDTO;
import org.project.coderlinkapi.service.ProjectProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectProgressController {

    private final ProjectProgressService projectProgressService;
    @PutMapping
    public ResponseEntity<ProjectMonitorDTO> updateProjectProgress(@PathVariable int projectId, @RequestBody ProjectMonitorDTO projectDetails) {
        ProjectMonitorDTO updatedProject = projectProgressService.updateProjectProgress(projectId, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }
    @GetMapping
    public ResponseEntity<ProjectMonitorDTO> getProjectById(@PathVariable int projectId) {
        ProjectMonitorDTO project = projectProgressService.getProjectById(projectId);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectMonitorDTO>> getAllProjects() {
        List<ProjectMonitorDTO> projects = projectProgressService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

}
