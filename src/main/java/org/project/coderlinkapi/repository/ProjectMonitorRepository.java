package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectMonitorRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findBYName(String milestones);

}