package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "postulations")
public class Postulations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "status", nullable = false, length = 150)
    private String status;
    @Column(name = "postulation_date", nullable = false)
    private LocalDateTime postulationDate;
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_postulations_developer"))
    private Developer developer;
}