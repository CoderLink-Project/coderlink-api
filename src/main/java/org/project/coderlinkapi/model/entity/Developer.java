package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Entity
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "portfolio", columnDefinition = "TEXT")
    private String portfolio;
    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;
    @Column(name = "hours_worked")
    private int hoursWorked;
    @Column(name = "payment_rate", nullable = false, length = 30)
    private double paymentRate;
    @Column(name = "work_experience", columnDefinition = "TEXT")
    private String workExperience;
    @Column(name = "years_experience", nullable = false, length = 10)
    private int yearsExperience;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_developer_user"))
    private User user;
}
