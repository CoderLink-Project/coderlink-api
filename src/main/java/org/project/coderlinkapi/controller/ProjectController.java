package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(@RequestParam String keyword) {
        List<Project> projects = projectService.searchProjects(keyword);
        return ResponseEntity.ok(projects);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
