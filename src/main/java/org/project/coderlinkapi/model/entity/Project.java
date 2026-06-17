package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "milestones", nullable = false, length = 150)
    private String milestones;

    @Column(name = "presentation", nullable = false, length = 150)
    private String presentation;

    @Column(name = "revision", nullable = false)
    private int revisions;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @Column(name = "completion_date", nullable = false)
    private LocalDateTime completionDate;

    @Column(name = "category_project", nullable = false, length = 50)
    private String categoryProject;

    @Column(name = "qualification", nullable = false)
    private BigDecimal qualification;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_project_customer"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_project_developer"))
    private Developer developer;

}
