package org.project.coderlinkapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectDTO {
    private Integer id;
    private String name;
    private String description;
    private String status;
    private BigDecimal qualification;
    private String categoryProject;
}
