package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.DeveloperDTO;
import org.project.coderlinkapi.dto.UpdateDeveloperRateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeveloperService {
    List<DeveloperDTO> getAll();
    Page<DeveloperDTO> paginate(Pageable pageable);
    DeveloperDTO findById(Integer id);
    DeveloperDTO create(DeveloperDTO DeveloperDTO);
    DeveloperDTO update(Integer id, DeveloperDTO updateDeveloperDTO);
    void delete(Integer id);
    DeveloperDTO updatePaymentRate(UpdateDeveloperRateDTO updateDeveloperRateDTO);
}
