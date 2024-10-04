package org.project.coderlinkapi.mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.ProjectMonitorDTO;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private final ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public ProjectMonitorDTO toDTO(Project project) {
        return modelMapper.map(project, ProjectMonitorDTO.class);
    }
  public Project toEntity(ProjectMonitorDTO ProjectMonitorDTO) {
        return modelMapper.map(ProjectMonitorDTO, Project.class);
  }
}
