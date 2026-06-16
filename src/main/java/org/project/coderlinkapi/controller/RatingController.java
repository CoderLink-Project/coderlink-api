package org.project.coderlinkapi.controller;

import org.project.coderlinkapi.dto.RatingRequestDTO;
import org.project.coderlinkapi.dto.RatingResponseDTO;
import org.project.coderlinkapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developers")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Endpoint para calificar un desarrollador
    @PostMapping("/{developerId}/rate")
    public ResponseEntity<RatingResponseDTO> rateDeveloper(@PathVariable Integer developerId,
                                                           @RequestBody RatingRequestDTO ratingRequestDTO) {
        RatingResponseDTO response = ratingService.rateDeveloper(developerId, ratingRequestDTO);
        return ResponseEntity.ok(response);
    }
}
