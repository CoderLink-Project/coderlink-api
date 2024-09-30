package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    @Override
    public List<DeveloperDTO> getAll() {
        return List.of();
    }

    @Override
    public Page<DeveloperDTO> paginate(Pageable pageable) {
        return null;
    }

    @Override
    public DeveloperDTO findById(Integer id) {
        return null;
    }

    @Override
    public DeveloperDTO create(DeveloperDTO AuthorDTO) {
        return null;
    }

    @Override
    public DeveloperDTO update(Integer id, DeveloperDTO updateAuthorDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
