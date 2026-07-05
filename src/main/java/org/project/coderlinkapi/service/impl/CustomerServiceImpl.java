package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.CustomerDTO;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.CustomerMapper;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerDTO setProjectMilestone(int projectId, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException(""));
        Customer savedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.toDTO(savedCustomer);
    }

    public List<CustomerDTO> getProjectMilestone(int projectId) {
        Customer customer = customerRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException(""));
        CustomerDTO customerDTO = customerMapper.toDTO(customer);
        return Collections.singletonList(customerDTO);
    }

    @Transactional(readOnly = true)

    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ID " + id + " no fue encontrado"));
        customerRepository.delete(customer);
    }
}
