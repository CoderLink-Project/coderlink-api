package org.project.coderlinkapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favorite_developers")
public class FavoriteDevelopers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_favorite_customer"))
    private Customer customer;  // Usuario que marca al desarrollador como favorito

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_favorite_developer"))
    private Developer developer;  // Desarrollador que es marcado como favorito
}