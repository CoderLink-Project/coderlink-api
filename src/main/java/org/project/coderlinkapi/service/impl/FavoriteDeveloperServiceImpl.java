package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.dto.FavoriteDeveloperResponseDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.FavoriteDeveloperMapper;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.model.entity.FavoriteDevelopers;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.project.coderlinkapi.service.FavoriteDeveloperService;
import org.project.coderlinkapi.repository.FavoriteDevelopersRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FavoriteDeveloperServiceImpl implements FavoriteDeveloperService {

    private final FavoriteDevelopersRepository favoriteDevelopersRepository;
    private final CustomerRepository customerRepository;
    private final DeveloperRepository developerRepository;
    private FavoriteDeveloperMapper favoriteDeveloperMapper;

    public FavoriteDeveloperResponseDTO addDeveloperToFavorites(Integer customerId, Integer developerId) {
        // Verificar que el cliente existe
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        // Verificar que el desarrollador existe
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found with id: " + developerId));

        // Crear la entidad FavoriteDevelopers
        FavoriteDevelopers favoriteDevelopers = new FavoriteDevelopers();
        favoriteDevelopers.setCustomer(customer);
        favoriteDevelopers.setDeveloper(developer);

        // Guardar la entidad en la base de datos
        FavoriteDevelopers savedFavorite = favoriteDevelopersRepository.save(favoriteDevelopers);

        // Mapear la entidad guardada a FavoriteDeveloperResponseDTO
        return favoriteDeveloperMapper.toResponseDTO(savedFavorite);
    }
}
