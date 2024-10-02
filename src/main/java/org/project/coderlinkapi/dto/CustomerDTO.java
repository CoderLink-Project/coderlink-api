package org.project.coderlinkapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre debe tener 50 caracteres o menos")
    private String firstName; // Nombre del cliente para identificar a la persona asociada con el hito.

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El apellido debe tener 50 caracteres o menos")
    private String lastName; // Apellido del cliente, que puede ser relevante para la comunicación sobre los hitos.

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(max = 500, message = "La descripcion debe tener 500 caracteres o menos")
    private String description; // Descripción que puede contener detalles relevantes sobre el cliente y sus expectativas en los hitos.

    @NotBlank(message = "El nombre de la compañia es obligatorio")
    @Size(max = 50, message = "El nombre de la compañia debe tener 50 caracteres o menos")
    private String nameCompany; // Nombre de la compañía que podría ser un factor en los hitos establecidos en un proyecto.

    @NotBlank(message = "El numero de telefono es obligatorio")
    @Size(max = 15, message = "El numero de telefono debe tener 15 caracteres o menos")
    private int phone; // Número de teléfono que puede ser utilizado para la comunicación sobre los hitos y avances del proyecto.
}


