package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.service.ModifyProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ModifyProjectController {

private final ModifyProjectService modifyProjectService;
    @PutMapping
    public ResponseEntity<ProjectDTO> updateProject(
            @PathVariable Integer projectId,
            @RequestParam Integer customerId,
            @RequestBody ProjectDTO projectDTO) {

        ProjectDTO updatedProject = modifyProjectService.updateProject(projectId, customerId, projectDTO);
        return ResponseEntity.ok(updatedProject);
    }

}
