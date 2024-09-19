package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Verifica si existe un usuario con el email o el id
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email OR u.id = :id")
    boolean existsByEmailOrId(@Param("email") String email, @Param("id") Long id);

    // Encuentra un usuario por id
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(@Param("id") Long id);

    // Encuentra un usuario por email
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    // Verifica si existe un usuario con el email
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    // Verifica si existe un usuario con el email y la contraseña
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email AND u.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
