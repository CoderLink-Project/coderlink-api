package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface HireDeveloperRepository extends JpaRepository<Developer, Integer> {
   //Buscar desarrolladores por su id
    @Override
    Optional<Developer> findById(Integer id);

    // Buscar desarrolladores por años de experiencia
    List<Developer> findByYearsExperienceGreaterThan(int yearsExperience);
}
