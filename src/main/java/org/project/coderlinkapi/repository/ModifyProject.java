package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModifyProject extends JpaRepository<Project, Integer> {
    Optional<Project> findByIdAndCustomerId(Integer projectId, Integer customerId);
}
