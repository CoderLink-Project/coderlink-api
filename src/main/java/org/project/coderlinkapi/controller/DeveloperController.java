package org.project.coderlinkapi.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.service.DeveloperService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("/search")
    public ResponseEntity<List<Developer>> searchDevelopers(@RequestParam String skill) {
        List<Developer> developers = developerService.searchDevelopersBySkill(skill);
        return ResponseEntity.ok(developers);
    }
}
