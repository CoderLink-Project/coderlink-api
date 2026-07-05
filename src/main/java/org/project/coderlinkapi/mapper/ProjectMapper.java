package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.SetProjectMilestoneDTO;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private final ModelMapper modelMapper;


    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public SetProjectMilestoneDTO toDTO(Project project) {
        return modelMapper.map(project, SetProjectMilestoneDTO.class);
    }
  public Project toEntity(SetProjectMilestoneDTO setProjectMilestoneDTO) {
        return modelMapper.map(setProjectMilestoneDTO, Project.class);
  }
}
