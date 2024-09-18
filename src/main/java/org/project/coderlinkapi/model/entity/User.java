package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.project.coderlinkapi.model.enums.Role;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "customers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "username", nullable = false, length = 20)
    private String userName;
    @Column(name="email", nullable = false, length = 100)
    private String email;
    @Column(name="pass" , nullable = false, length = 50)
    private String password;
    @Column(name = "typeuser", nullable = false, length = 20)
    private boolean typeUser; //"admin", "cliente", "desarrollador"
    @Column(name = "ubication", nullable = false, length = 20)
    private String ubication;
    private Boolean isAdmin = false;
    @Column(name="created_at")
    private LocalDate createAt;
    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    private Developer developer;

    @OneToOne
    private Customer customer;
}
