package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.FavoriteDevelopers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import java.util.List;

public interface FavoriteDevelopersRepository  extends JpaRepository<FavoriteDevelopers, Integer> {
    List<FavoriteDevelopers> findByUserId(Integer userId);

    // Encontrar un desarrollador específico dentro de los favoritos de un usuario
    Optional<FavoriteDevelopers> findByUserIdAndDeveloperId(Integer userId, Integer developerId);
    // Eliminar un desarrollador de los favoritos de un usuario
    void deleteByUserIdAndDeveloperId(Integer userId, Integer developerId);
}
