package org.project.coderlinkapi.dto;

import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.model.entity.Skill;
import org.project.coderlinkapi.model.enums.ERole;

import lombok.Data;

import java.util.List;

@Data
public class UserProfileDTO {

    private Integer id;
    private String email;
    private ERole role;  // El rol puede ser CUSTOMER o DEVELOPER

    // Campos específicos para Customer
    private String firstName;  // Nombre del cliente o autor
    private String lastName;   // Apellido del cliente o autor
    private String description;
    private List<Project> projects;  // Solo para el cliente (Customer)

    // Campos específicos para Developer
    private Double rating;
    private Double paymentRate;
    private String workExperience;
    private String portafolio;
    private Skill skill;
}
