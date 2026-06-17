package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.CheckHistoryCompletedDTO;
import org.project.coderlinkapi.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class CheckHistoryCompletedMapper {
    private final ModelMapper modelMapper;

    public CheckHistoryCompletedMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public CheckHistoryCompletedDTO toDTO(Project project) {
        return modelMapper.map(project, CheckHistoryCompletedDTO.class);
    }

    public Project toEntity(CheckHistoryCompletedDTO checkHistoryCompletedDTO) {
        return modelMapper.map(checkHistoryCompletedDTO, Project.class);
    }
}
