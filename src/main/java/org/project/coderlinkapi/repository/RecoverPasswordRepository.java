package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecoverPasswordRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
