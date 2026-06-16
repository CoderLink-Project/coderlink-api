package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.project.coderlinkapi.model.enums.ERole;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    // Relación uno a uno con Customer (si el usuario es cliente)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    // Relación con Developer (si el usuario es desarrollador)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Developer developer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}

