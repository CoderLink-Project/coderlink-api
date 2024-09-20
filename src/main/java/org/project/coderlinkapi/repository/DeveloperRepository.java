package org.project.coderlinkapi.repository;
import org.project.coderlinkapi.model.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    List<Developer> findBySkillSetContaining(String skill);
}
