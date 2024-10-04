package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstname;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastname;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "nameCompany", nullable = false, length = 20)
    private String nameCompany;

    @Column(name = "phone", nullable = false, length = 9)
    private int phone;

    // Atributos de auditoría para el perfil del cliente
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Project> projects;
}
