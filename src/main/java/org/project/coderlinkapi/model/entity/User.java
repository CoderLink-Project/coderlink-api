package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.project.coderlinkapi.model.enums.Role;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String userName;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="pass", nullable = false, length = 50)
    private String password;

    @Column(name="created_at")
    private LocalDate createAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    @OneToOne(mappedBy = "user")
    private Developer developer;
}

