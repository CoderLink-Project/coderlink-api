package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.project.coderlinkapi.dto.RecoverPasswordDTO;
import org.springframework.stereotype.Component;
import org.project.coderlinkapi.model.entity.User;

@Component
public class RecoverPasswordMapper {
    private final ModelMapper modelMapper;

    public RecoverPasswordMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public RecoverPasswordDTO toDTO(User user) {
        return modelMapper.map(user, RecoverPasswordDTO.class);
    }

    public User toEntity(RecoverPasswordDTO recoverPasswordDTO) {
        return modelMapper.map(recoverPasswordDTO, User.class);
    }
}
