package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.dto.JobOfferCreateEditDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminJobOfferService {
    List<JobOfferDetailsDTO> findAll();
    Page<JobOfferDetailsDTO> paginate(Pageable pageable);
    JobOfferDetailsDTO findById(Integer id);
    JobOfferDetailsDTO create(JobOfferCreateEditDTO jobofferCreateEditDTO);
    JobOfferDetailsDTO update(Integer id, JobOfferCreateEditDTO editJobOfferDTO);
    void delete(Integer id);
}
