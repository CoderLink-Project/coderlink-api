package org.project.coderlinkapi.mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.dto.HireDeveloperDTO;

@Component
public class HireDeveloperMapper {

    private final ModelMapper modelMapper;

    public HireDeveloperMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar ModelMapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // Mapeo de Developer a HireDeveloperDTO
    public HireDeveloperDTO toDTO(Developer developer) {
        return modelMapper.map(developer, HireDeveloperDTO.class);
    }

    // Mapeo de HireDeveloperDTO a Developer (entidad)
    public Developer toEntity(HireDeveloperDTO hireDeveloperDTO) {
        return modelMapper.map(hireDeveloperDTO, Developer.class);
    }
}
