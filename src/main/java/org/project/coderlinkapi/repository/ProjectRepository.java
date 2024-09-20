package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNameContainingOrDescriptionContaining(String name, String description);
}
