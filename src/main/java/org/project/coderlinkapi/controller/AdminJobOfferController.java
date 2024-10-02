package org.project.coderlinkapi.controller;
import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.service.AdminJobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/joboffer")
@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
public class AdminJobOfferController {
    private final AdminJobOfferService adminJobOfferService;
    @GetMapping
    public ResponseEntity<List<JobOfferDetailsDTO>> list() {
        List<JobOfferDetailsDTO> jobOffers = adminJobOfferService.findAll();
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adminJobOfferService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}