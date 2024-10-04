package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "developer")
public class Developer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "portfolio", columnDefinition = "TEXT")
    private String portfolio;
    // Calificación en estrellas (1 a 5)
    @Column(name = "rating", nullable = true)
    @Min(1)  // Mínimo 1 estrella
    @Max(5)  // Máximo 5 estrellas
    private Double rating;
    //@Column(name = "skills", columnDefinition = "TEXT")
    //private String skills;
    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;
    @Column(name = "hours_worked")
    private int hoursWorked;
    @Column(name = "payment_rate", nullable = false, length = 30)
    private Double paymentRate;
    @Column(name = "work_experience", columnDefinition = "TEXT")
    private String workExperience;
    @Column(name = "years_experience", nullable = false, length = 10)
    private int yearsExperience;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    // Atributos de auditoría para el perfil del cliente
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
