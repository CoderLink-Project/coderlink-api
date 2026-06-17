package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre debe tener 50 caracteres o menos")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El apellido debe tener 50 caracteres o menos")
    private String lastName;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(max = 500, message = "La descripcion debe tener 500 caracteres o menos")
    private String description;

    @NotBlank(message = "El nombre de la compañia es obligatorio")
    @Size(max = 50, message = "El nombre de la compañia debe tener 50 caracteres o menos")
    private String nameCompany;

    @NotBlank(message = "El numero de telefono es obligatorio")
    @Size(max = 15, message = "El numero de telefono debe tener 15 caracteres o menos")
    private int phone;
}

