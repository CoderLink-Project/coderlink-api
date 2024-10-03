package org.project.coderlinkapi.controller;

import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.service.DeveloperService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.project.coderlinkapi.dto.CheckHistoryCompletedDTO;
import org.project.coderlinkapi.service.CheckHistoryCompletedService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/developers")
@PreAuthorize("hasRole('ADMIN')")
public class DeveloperController {

    private final DeveloperService developerService;

    private final CheckHistoryCompletedService checkHistoryCompletedService;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> listAll() {
        List<DeveloperDTO> developers = developerService.getAll();
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DeveloperDTO>> paginate(@PageableDefault(size = 5, sort = "firstName")
                                                      Pageable pageable) {
        Page<DeveloperDTO> page = developerService.paginate(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> create(@Valid @RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO createdDeveloper = developerService.create(developerDTO);
        return new ResponseEntity<>(createdDeveloper, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getById(@PathVariable Integer id) {
        DeveloperDTO developer = developerService.findById(id);
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeveloperDTO> update(@PathVariable Integer id,@Valid @RequestBody DeveloperDTO developerDTO) {
        DeveloperDTO updatedDeveloper = developerService.update(id, developerDTO);
        return new ResponseEntity<>(updatedDeveloper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        developerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public List<CheckHistoryCompletedDTO> getCompletedProjectsByAuthenticatedDeveloper() {
        // Obtener el ID del desarrollador autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int developerId = getAuthenticatedDeveloperId(authentication); // Método que obtiene el ID del desarrollador autenticado

        // Obtener los proyectos completados por el desarrollador
        List<CheckHistoryCompletedDTO> projects = checkHistoryCompletedService.getCompletedProjectsByDeveloperId(developerId);

        // Si no hay proyectos completados, devolver un mensaje adecuado
        if (projects.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No hay proyectos completados aún.");
        }

        return projects;
    }

    // Obtener los detalles de un proyecto específico completado por el desarrollador autenticado
    @GetMapping("/me/completed-projects/{projectId}")
    public CheckHistoryCompletedDTO getCompletedProjectDetails(@PathVariable int projectId) {
        // Obtener el ID del desarrollador autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int developerId = getAuthenticatedDeveloperId(authentication);

        // Obtener los detalles del proyecto solo si pertenece al desarrollador autenticado
        return checkHistoryCompletedService.getCompletedProjectDetailsForDeveloper(developerId, projectId);
    }

    // Método auxiliar para obtener el ID del desarrollador autenticado
    private int getAuthenticatedDeveloperId(Authentication authentication) {
        return 123;  // Este es solo un ejemplo estático, debes ajustarlo según tu autenticación
    }
}
