package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "milestones", nullable = false, length = 10)
    private String milestones;
    @Column(name = "presentation", nullable = false, length = 50)
    private String presentation;
    @Column(name = "revision", nullable = false)
    private int revisions;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "category_project",nullable = false, length = 30)
    private String categoryProject;
    @Column(name = "qualification", nullable = false)
    private double qualification;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_project"))
    private Customer client;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;
}