package org.project.coderlinkapi.controller;

import org.project.coderlinkapi.dto.JobOfferCreateEditDTO;
import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.project.coderlinkapi.service.AdminJobOfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/joboffer")
@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")  // Permitir solo a CUSTOMER y AUTHOR
public class AdminJobOfferController {
    private final AdminJobOfferService adminJobOfferService;

    @GetMapping
    public ResponseEntity<List<JobOfferDetailsDTO>> list() {
        List<JobOfferDetailsDTO> jobOffers = adminJobOfferService.findAll();
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<JobOfferDetailsDTO>> paginate(
            @PageableDefault(size = 5, sort = "title") Pageable pageable) {
        Page<JobOfferDetailsDTO> page =adminJobOfferService.paginate(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobOfferDetailsDTO> create(@Valid @RequestBody JobOfferCreateEditDTO jobOfferFormDTO) {
        JobOfferDetailsDTO createdJobOffer = adminJobOfferService.create(jobOfferFormDTO);
        return new ResponseEntity<>(createdJobOffer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobOfferDetailsDTO> get(@PathVariable Integer id) {
        JobOfferDetailsDTO jobOffer = adminJobOfferService.findById(id);
        return new ResponseEntity<>(jobOffer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobOfferDetailsDTO> update(@PathVariable Integer id,
                                                 @Valid @RequestBody JobOfferCreateEditDTO jobOfferFormDTO) {
        JobOfferDetailsDTO updatedJobOffer = adminJobOfferService.update(id, jobOfferFormDTO);
        return new ResponseEntity<>(updatedJobOffer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adminJobOfferService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}