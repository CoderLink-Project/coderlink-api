package org.project.coderlinkapi.dto;
import lombok.Data;
@Data

public class HireDeveloperDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String description;
    private int yearsExperience;
    private Double rating;
    private Double payment_rate;

}