package org.project.coderlinkapi.service;
import org.project.coderlinkapi.dto.SetProjectMilestoneDTO;
import java.util.List;

public interface SetProjectMilestoneService {
    SetProjectMilestoneDTO setProjectMilestone(int projectId, SetProjectMilestoneDTO setProjectMilestoneDTO);
  List<SetProjectMilestoneDTO> getMilestones(int projectId);
    void delete(Integer id);

}
