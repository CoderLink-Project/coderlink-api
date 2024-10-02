package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.service.AvailableProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping
@RestController
public class AvailableProjectController {

private final AvailableProjectService availableProjectService;

    @GetMapping("/available")
    public ResponseEntity<List<ProjectDTO>> getAvailableProjects() {
        List<ProjectDTO> availableProjects = availableProjectService.getAvailableProjects();
        if (availableProjects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(availableProjects);
    }

}
