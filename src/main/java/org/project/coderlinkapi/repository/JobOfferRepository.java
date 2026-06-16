package org.project.coderlinkapi.repository;

import org.project.coderlinkapi.model.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
    Optional<JobOffer> findByTitle(String title);
}
