package org.project.coderlinkapi.mapper;


import org.project.coderlinkapi.dto.JobOfferDetailsDTO;
import org.project.coderlinkapi.dto.JobOfferCreateEditDTO;
import org.modelmapper.ModelMapper;
import org.project.coderlinkapi.model.entity.JobOffer;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class JobOfferMapper {
    private final ModelMapper modelMapper;

    public JobOfferMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        //Configurar ModelMapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public JobOfferDetailsDTO toDetailsDTO(JobOffer jobOffer) {
        JobOfferDetailsDTO jobOfferDetailsDTO =  modelMapper.map(jobOffer, JobOfferDetailsDTO.class);

        jobOfferDetailsDTO.setProjectName(jobOffer.getProject().getName());
        jobOfferDetailsDTO.setCustomerName(jobOffer.getCustomer().getFirstname()+" "+jobOffer.getCustomer().getLastname());


        return jobOfferDetailsDTO;
    }

    public JobOffer toEntity(JobOfferCreateEditDTO jobOfferCreateEditDTO) {
        return modelMapper.map(jobOfferCreateEditDTO, JobOffer.class);
    }

    public JobOfferCreateEditDTO toCreateUpdateDTO(JobOffer jobOffer) {
        return modelMapper.map(jobOffer, JobOfferCreateEditDTO.class);
    }

    // Mapeo de JobOffer a JobOfferDetailsDTO (para mostrar información completa)
    public JobOfferDetailsDTO toDetailsDto(JobOffer jobOffer) {
        JobOfferDetailsDTO jobofferDetailsDTO = modelMapper.map(jobOffer, JobOfferDetailsDTO.class);
        // Mapear manualmente el nombre del cliente concatenando firstName y lastName
        jobofferDetailsDTO.setCustomerName(jobOffer.getCustomer().getFirstname() + " " + jobOffer.getCustomer().getLastname());
        // Mapear manualmente el nombre del projecto
        jobofferDetailsDTO.setProjectName(jobOffer.getProject().getName());
        return jobofferDetailsDTO;
    }
}