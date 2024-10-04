package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Postulations;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostulationRepository extends JpaRepository<Postulations, Integer> {
    Optional<Postulations> findById(Integer id);
}
