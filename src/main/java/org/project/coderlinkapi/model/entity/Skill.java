package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;

}
