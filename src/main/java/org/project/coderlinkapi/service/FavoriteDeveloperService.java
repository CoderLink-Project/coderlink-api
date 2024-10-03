package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.FavoriteDeveloperResponseDTO;
public interface FavoriteDeveloperService {
    FavoriteDeveloperResponseDTO addDeveloperToFavorites(Integer customerId, Integer developerId);
}