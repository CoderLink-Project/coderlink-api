package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    // Método para buscar un usuario por email (será usado en la autenticación)
    Optional<User> findByEmail(String email);
}