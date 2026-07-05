package org.project.coderlinkapi.controller;
import org.project.coderlinkapi.dto.CustomerDTO;
import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
@PreAuthorize("hasRole('ADMIN')")
public class CustomerController {

    private final CustomerService customerService;
@GetMapping
    public ResponseEntity<List<CustomerDTO>> getProjectMilestone(@PathVariable int projectId) {
        List<CustomerDTO> milestones = customerService.getProjectMilestone(projectId);
        return  ResponseEntity.ok(milestones);
    }
    @PutMapping
        public ResponseEntity<CustomerDTO> setProjectMilestone(@PathVariable int projectId, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedProjectDTO = customerService.setProjectMilestone(projectId, customerDTO);
        return ResponseEntity.ok(updatedProjectDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
