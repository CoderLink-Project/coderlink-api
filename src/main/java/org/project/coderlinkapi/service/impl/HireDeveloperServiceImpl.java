package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.HireDeveloperDTO;
import org.project.coderlinkapi.exception.DeveloperNotFoundException;
import org.project.coderlinkapi.mapper.HireDeveloperMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.HireDeveloperRepository;
import org.project.coderlinkapi.service.HireDeveloperService;
import org.springframework.stereotype.Service;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class HireDeveloperServiceImpl implements HireDeveloperService {

    private HireDeveloperRepository hireDeveloperRepository;

    private HireDeveloperMapper hireDeveloperMapper;

    @Override
    public HireDeveloperDTO hireDeveloper(HireDeveloperDTO hireDeveloperDTO) {
        // Convertir el DTO a entidad
        Developer developer = hireDeveloperMapper.toEntity(hireDeveloperDTO);

        // Guardar el desarrollador en la base de datos
        Developer savedDeveloper = hireDeveloperRepository.save(developer);

        // Convertir la entidad guardada a DTO y devolverla
        return hireDeveloperMapper.toDTO(savedDeveloper);
    }

    @Override
    public HireDeveloperDTO getDeveloperByid(Integer id) {
        // Buscar el desarrollador por su DNI
        Optional<Developer> developerOptional = hireDeveloperRepository.findById(id);
        Developer developer;
        if (developerOptional.isPresent()) {
            developer = developerOptional.get();
            //return hireDeveloperMapper.toDTO(developer);
        } else {
            throw new DeveloperNotFoundException("No se encontró el desarrollador con ID: \" + id");
        }

        // Convertir la entidad a DTO y devolverla
        return hireDeveloperMapper.toDTO(developer);
    }
}
