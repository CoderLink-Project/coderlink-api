package org.project.coderlinkapi.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.coderlinkapi.model.dto.UserRequestDTO;
import org.project.coderlinkapi.model.dto.UserResponseDTO;
import org.project.coderlinkapi.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    public User convertToEntity(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, User.class);
    }

    public UserResponseDTO convertToDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public List<UserResponseDTO> convertToListDTO(List<User> accounts) {
        return accounts.stream()
                .map(this::convertToDTO)
                .toList();
    }
}