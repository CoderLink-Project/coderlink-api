package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.JobOfferCreateEditDTO;
import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.exception.BadRequestException;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.JobOfferMapper;
import org.project.coderlinkapi.model.entity.Project;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.repository.JobOfferRepository;
import org.project.coderlinkapi.repository.ProjectRepository;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.service.AdminJobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminJobOfferServiceImpl implements AdminJobOfferService {
    private final JobOfferRepository jobofferRepository;
    private final CustomerRepository customerRepository;
    private final ProjectRepository projectRepository;
    private final JobOfferMapper jobofferMapper;

    @Transactional(readOnly = true)
    @Override
    public List<JobOfferDetailsDTO> findAll() {
        List<JobOffer> joboffers = jobofferRepository.findAll();
        return joboffers.stream()
                .map(jobofferMapper::toDetailsDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<JobOfferDetailsDTO> paginate(Pageable pageable) {
        return jobofferRepository.findAll(pageable)
                .map(jobofferMapper::toDetailsDTO);
    }

    @Transactional
    @Override
    public JobOfferDetailsDTO create(JobOfferCreateEditDTO jobofferCreateEditDTO) {
        jobofferRepository.findByTitle(jobofferCreateEditDTO.getTitle())
                .ifPresent(jobOffer -> {
                    throw new BadRequestException("Ya existe una oferta de trabajo con el mismo título"); // Mensaje mejorado
                });

        // Asigna el proyecto y el cliente antes de guardar
        Project project = projectRepository.findById(jobofferCreateEditDTO.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + jobofferCreateEditDTO.getProjectId()));
        Customer customer = customerRepository.findById(jobofferCreateEditDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + jobofferCreateEditDTO.getCustomerId()));

        JobOffer jobOffer = jobofferMapper.toEntity(jobofferCreateEditDTO);

        jobOffer.setProject(project);
        jobOffer.setCustomer(customer);
        jobOffer.setCreatedAt(LocalDateTime.now());

        return jobofferMapper.toDetailsDTO(jobofferRepository.save(jobOffer));
    }

    @Transactional(readOnly = true)
    @Override
    public JobOfferDetailsDTO findById(Integer id) {
        JobOffer jobOffer = jobofferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Offer not found with id: " + id));
        return jobofferMapper.toDetailsDTO(jobOffer);
    }

    @Transactional
    @Override
    public JobOfferDetailsDTO update(Integer id, JobOfferCreateEditDTO updatedJobOffer) {
        JobOffer jobOfferFromDb = jobofferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Offer not found with id: " + id));

        jobofferRepository.findByTitle(updatedJobOffer.getTitle())
                .ifPresent(jobOffer -> {
                    throw new BadRequestException("Ya existe una oferta de trabajo con el mismo título"); // Mensaje mejorado
                });

        // Asigna el proyecto y el cliente antes de actualizar
        Project project = projectRepository.findById(updatedJobOffer.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + updatedJobOffer.getProjectId()));
        Customer customer = customerRepository.findById(updatedJobOffer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + updatedJobOffer.getCustomerId()));

        // Actualización de los campos de la oferta de trabajo
        jobOfferFromDb.setDescription(updatedJobOffer.getDescription());
        jobOfferFromDb.setBudget(updatedJobOffer.getBudget());
        jobOfferFromDb.setDuration(updatedJobOffer.getDuration());
        jobOfferFromDb.setUpdatedAt(LocalDateTime.now());
        jobOfferFromDb.setProject(project);
        jobOfferFromDb.setCustomer(customer);


        return jobofferMapper.toDetailsDTO(jobofferRepository.save(jobOfferFromDb));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        JobOffer jobOffer = jobofferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Offer not found with id: " + id));
        jobofferRepository.delete(jobOffer);
    }
}

