package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.DeveloperMapper;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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


    @Transactional
    @Override
    public void delete(Integer id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El desarrollador con ID " + id + " no fue encontrado"));
        developerRepository.delete(developer);
    }
}

