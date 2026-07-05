package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.exception.BadRequestException;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.DeveloperMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<DeveloperDTO> getAll() {
        List<Developer> developers = developerRepository.findAll();
        return developers.stream()
                .map(developerMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<DeveloperDTO> paginate(Pageable pageable) {
        Page<Developer> developers = developerRepository.findAll(pageable);
        return developers.map(developerMapper::toDTO);
    }


    @Transactional(readOnly = true)
    @Override
    public DeveloperDTO findById(Integer id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El desarrollador con ID "+id+" no fue encontrado"));
        return developerMapper.toDTO(developer);
    }

    @Transactional
    @Override
    public DeveloperDTO create(DeveloperDTO developerDTO) {
        developerRepository.findByFirstNameAndLastName(developerDTO.getFirstName(), developerDTO.getLastName())
                .ifPresent(existingAuthor ->{
                    throw new BadRequestException("El desarrollador ya existe con el mismo nombre y apellido");
                });

        Developer developer = developerMapper.toEntity(developerDTO);
        developer.setCreatedAt(LocalDateTime.now());
        developer = developerRepository.save(developer);
        return developerMapper.toDTO(developer);
    }

    @Transactional
    @Override
    public DeveloperDTO update(Integer id, DeveloperDTO updateDeveloperDTO) {
        Developer developerFromDb = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El desarrollador con ID " + id + " no fue encontrado"));


        developerRepository.findByFirstNameAndLastName(updateDeveloperDTO.getFirstName(), updateDeveloperDTO.getLastName())
                .filter(existingDeveloper -> !existingDeveloper.getId().equals(id))
                .ifPresent(existingDeveloper -> {
                    throw new BadRequestException("Ya existe un desarrollador con el mismo nombre y apellido");
                });

        // Actualizar los campos
        developerFromDb.setFirstName(updateDeveloperDTO.getFirstName());
        developerFromDb.setLastName(updateDeveloperDTO.getLastName());
        developerFromDb.setDescription(updateDeveloperDTO.getDescription());
        developerFromDb.setRating(updateDeveloperDTO.getRating());
        developerFromDb.setSkill(updateDeveloperDTO.getSkill());
        developerFromDb.setHoursWorked(updateDeveloperDTO.getHoursWorked());
        developerFromDb.setPaymentRate(updateDeveloperDTO.getPaymentRate());
        developerFromDb.setWorkExperience(updateDeveloperDTO.getWorkExperience());
        developerFromDb.setYearsExperience(updateDeveloperDTO.getYearsExperience());
        developerFromDb.setUpdatedAt(LocalDateTime.now());

        developerFromDb = developerRepository.save(developerFromDb);
        return developerMapper.toDTO(developerFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El desarrollador con ID " + id + " no fue encontrado"));
        developerRepository.delete(developer);
    }
}

