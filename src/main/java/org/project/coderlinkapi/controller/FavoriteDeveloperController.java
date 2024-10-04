package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.FavoriteDeveloperResponseDTO;
import org.project.coderlinkapi.service.FavoriteDeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RequestMapping
@RestController
public class FavoriteDeveloperController {


    private  final FavoriteDeveloperService favoriteDeveloperService;

    // Endpoint para agregar un desarrollador a favoritos
    @PostMapping("/favorites/{developerId}")
    public ResponseEntity<FavoriteDeveloperResponseDTO> addDeveloperToFavorites(
            @PathVariable Integer developerId,
            @RequestParam Integer customerId) {


        FavoriteDeveloperResponseDTO responseDTO = favoriteDeveloperService.addDeveloperToFavorites(customerId, developerId);


        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


}
