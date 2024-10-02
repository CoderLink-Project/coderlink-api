package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.project.coderlinkapi.dto.RequestDTO;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectRequestMapper {
    private final ModelMapper modelMapper;
    public ProjectRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public RequestDTO toDTO(Project project) {
        return modelMapper.map(project, RequestDTO.class);
    }
    public Project toEntity(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Project.class);
    }
}
