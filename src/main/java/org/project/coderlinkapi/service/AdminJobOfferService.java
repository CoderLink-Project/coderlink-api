package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import java.util.List;

public interface AdminJobOfferService {
    List<JobOfferDetailsDTO> findAll();
    void delete(Integer id);
}
