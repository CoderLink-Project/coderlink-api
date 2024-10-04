package org.project.coderlinkapi.controller;
import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/developers")
@PreAuthorize("hasRole('ADMIN')")
public class DeveloperController {

    private final DeveloperService developerService;


    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> getMilestones(@PathVariable int projectId) {
     List<DeveloperDTO> milestones = developerService.getProjectMilestone(projectId);
     return  ResponseEntity.ok(milestones);
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> setProjectMilestone(@PathVariable int projectId, @RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO updatedProjectDTO = developerService.setProjectMilestone(projectId, developerDTO);
        return ResponseEntity.ok(updatedProjectDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        developerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
