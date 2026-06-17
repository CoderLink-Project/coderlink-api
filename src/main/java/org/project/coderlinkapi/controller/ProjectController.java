package org.project.coderlinkapi.controller;

import org.project.coderlinkapi.dto.ProjectDTO;
import org.project.coderlinkapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> listAll() {
        List<ProjectDTO> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProjectDTO>> paginate(@PageableDefault(size = 5) Pageable pageable) {
        Page<ProjectDTO> page = projectService.paginate(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO createdProject = projectService.create(projectDTO);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable Integer id) {
        ProjectDTO project = projectService.findById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
        ProjectDTO updatedProject = projectService.update(id, projectDTO);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
