package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.DeveloperDTO;
import java.util.List;

public interface DeveloperService {
    DeveloperDTO setProjectMilestone(int projectId, DeveloperDTO developerDTO);
    List<DeveloperDTO> getProjectMilestone(int projectId);
    void delete(Integer id);
}
