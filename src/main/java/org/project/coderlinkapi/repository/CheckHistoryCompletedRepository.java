package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckHistoryCompletedRepository extends JpaRepository<Project, Integer> {

    List<Project> findByDeveloperId(int developerId);
}