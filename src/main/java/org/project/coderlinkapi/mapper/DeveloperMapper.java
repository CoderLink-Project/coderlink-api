package org.project.coderlinkapi.mapper;

import org.modelmapper.ModelMapper;
import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.dto.UpdateDeveloperRateDTO;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class    DeveloperMapper {
    private final ModelMapper modelMapper;

    public DeveloperMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public DeveloperDTO toDTO (Developer developer){
        return  modelMapper.map(developer, DeveloperDTO.class);
    }

    public Developer toEntity(DeveloperDTO developerDTO){
        return modelMapper.map(developerDTO, Developer.class);
    }

    // Actualizar la tarifa en la entidad Developer a partir del DTO
    public Developer updatePaymentRateFromDTO(Developer developer, UpdateDeveloperRateDTO updateDeveloperRateDTO) {
        developer.setPaymentRate(updateDeveloperRateDTO.getNewPaymentRate());
        return developer;
    }
}