package org.project.coderlinkapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobOfferDetailsDTO {
    private Integer id;
    private String description;
    private Double budget;
    private LocalDate duration;
    private LocalDate publicationDate;
    private String projectName;
    private String customerName;
}
