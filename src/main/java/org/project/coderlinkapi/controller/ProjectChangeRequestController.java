package org.project.coderlinkapi.controller;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.RequestDTO;
import org.project.coderlinkapi.service.ProjectChangeRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ProjectChangeRequestController {
    private final ProjectChangeRequestService projectChangeRequestService;

    @PostMapping
    public ResponseEntity<RequestDTO> requestProjectChange(@PathVariable int projectId, @RequestBody RequestDTO requestDTO) {
        RequestDTO updatedRequest = projectChangeRequestService.requestProjectChange(projectId, requestDTO);
        return ResponseEntity.ok(updatedRequest);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteChangeRequest(@PathVariable int projectId) {
        projectChangeRequestService.deleteChangeRequest(projectId);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllChangeRequests() {
        List<RequestDTO> allChangeRequests = projectChangeRequestService.getAllChangeRequests();
        return ResponseEntity.ok(allChangeRequests);
    }
}
