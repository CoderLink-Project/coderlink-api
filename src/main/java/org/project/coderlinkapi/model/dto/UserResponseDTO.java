package org.project.coderlinkapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.coderlinkapi.model.enums.Role;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String userName;
    private String email;
    private LocalDate createAt;
    private LocalDate updatedAt;
    private Role role;
}