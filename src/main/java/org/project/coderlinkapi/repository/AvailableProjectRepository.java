package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableProjectRepository  extends JpaRepository<Project, Integer> {
    List<Project> findByDeveloperIsNull();
}

