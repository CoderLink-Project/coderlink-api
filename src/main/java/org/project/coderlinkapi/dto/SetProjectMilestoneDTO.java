package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SetProjectMilestoneDTO {
    private int id;
    @NotBlank(message = "El nombre es obligatorio")
    private String Name;
    @NotBlank(message = "La descripcion debe tener entre 100 o menos caracteres")

    private String Description;
    @NotBlank(message = "El revision debe tener entre 50 o menos caracteres")

    private int revisions;
    @NotBlank(message = "La categoria del projecto debe ser entre 9 o menos listas")

    private String categoryProject;


}
