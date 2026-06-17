package org.project.coderlinkapi.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckHistoryCompletedDTO {
        private Integer id;
        private String projectName;
        private String description;
        private Double budget;
        private LocalDateTime completionDate;
        private Double rating;
    }
