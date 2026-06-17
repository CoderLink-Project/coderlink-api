package org.project.coderlinkapi.model.entity;

import org.project.coderlinkapi.model.enums.ERole;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)  // Esto almacena el nombre del enum como String en la base de datos
    @Column(name = "name", nullable = false, unique = true)
    private ERole name;  // Cambiamos el tipo a RoleEnum
}
