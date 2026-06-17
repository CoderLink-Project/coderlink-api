package org.project.coderlinkapi.repository;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    Optional<Developer> findByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    // Método para verificar si ya existe un desarrollador con el mismo nombre y apellido, excepto el usuario actual
    boolean existsByFirstNameAndLastNameAndUserIdNot(String firstName, String lastName, Integer userId);
}
    //@Query("SELECT d FROM Developer d WHERE d.skill.name=?1")
    //List<Developer>  findBySkillContaining(String skillName);

