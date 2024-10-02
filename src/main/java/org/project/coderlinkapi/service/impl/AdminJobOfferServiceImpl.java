package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.JobOfferMapper;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.project.coderlinkapi.repository.JobOfferRepository;
import org.project.coderlinkapi.service.AdminJobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminJobOfferServiceImpl implements AdminJobOfferService {
    private final JobOfferRepository jobofferRepository;
    private final JobOfferMapper jobofferMapper;

    @Transactional(readOnly = true)

    public List<JobOfferDetailsDTO> findAll() {
        List<JobOffer> joboffers = jobofferRepository.findAll();
        return joboffers.stream()
                .map(jobofferMapper::toDetailsDTO)
                .toList();
    }
    @Transactional(readOnly = true)

    public void delete(Integer id) {
        JobOffer jobOffer = jobofferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Offer not found with id: " + id));
        jobofferRepository.delete(jobOffer);
    }
}

