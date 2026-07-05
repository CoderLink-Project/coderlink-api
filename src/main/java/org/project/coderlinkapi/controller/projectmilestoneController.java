package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.SetProjectMilestoneDTO;
import org.project.coderlinkapi.service.SetProjectMilestoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
@RequiredArgsConstructor
@RequestMapping
@RestController
public class projectmilestoneController {
  private final SetProjectMilestoneService setProjectMilestoneService;

  @GetMapping
  public ResponseEntity<List<SetProjectMilestoneDTO>> getMilestones(@PathVariable int projectId) {
      List<SetProjectMilestoneDTO> milestones = setProjectMilestoneService.getMilestones(projectId);
      return ResponseEntity.ok(milestones);
  }
    @PutMapping
    public ResponseEntity<SetProjectMilestoneDTO> setProjectMilestone(@PathVariable int projectId, @RequestBody  SetProjectMilestoneDTO setProjectMilestoneDTO) {
        SetProjectMilestoneDTO updatedSetProjectMilestoneDTO = setProjectMilestoneService.setProjectMilestone(projectId, setProjectMilestoneDTO);
        return ResponseEntity.ok(updatedSetProjectMilestoneDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        setProjectMilestoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
