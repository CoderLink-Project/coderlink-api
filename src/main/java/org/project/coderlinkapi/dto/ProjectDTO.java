package org.project.coderlinkapi.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProjectDTO {
    private Integer id;
    private String name;
    private String description;
    private String milestones;
    private String presentation;
    private int revisions;
    private String status;
    private String categoryProject;
    private BigDecimal qualification;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer customerId;
    private Integer developerId;
}
