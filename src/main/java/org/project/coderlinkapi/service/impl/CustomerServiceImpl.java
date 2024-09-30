package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.CustomerDTO;
import org.project.coderlinkapi.exception.BadRequestException;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.project.coderlinkapi.mapper.CustomerMapper;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CustomerDTO> paginate(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(customerMapper::toDTO);
    }


    @Transactional(readOnly = true)
    @Override
    public CustomerDTO findById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El cliente con ID "+id+" no fue encontrado"));
        return customerMapper.toDTO(customer);
    }

    @Transactional
    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        customerRepository.findByFirstNameAndLastName(customerDTO.getFirstName(), customerDTO.getLastName())
                .ifPresent(existingAuthor ->{
                    throw new BadRequestException("El cliente ya existe con el mismo nombre y apellido");
                });

        Customer customer = customerMapper.toEntity(customerDTO);
        customer.setCreatedAt(LocalDateTime.now());
        customer = customerRepository.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Transactional
    @Override
    public CustomerDTO update(Integer id, CustomerDTO updateCustomerDTO) {
        Customer customerFromDb = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ID " + id + " no fue encontrado"));


        customerRepository.findByFirstNameAndLastName(updateCustomerDTO.getFirstName(), updateCustomerDTO.getLastName())
                .filter(existingCustomer -> !existingCustomer.getId().equals(id))
                .ifPresent(existingcCstomer -> {
                    throw new BadRequestException("Ya existe un cliente con el mismo nombre y apellido");
                });

        // Actualizar los campos
        customerFromDb.setFirstname(updateCustomerDTO.getFirstName());
        customerFromDb.setLastname(updateCustomerDTO.getLastName());
        customerFromDb.setDescription(updateCustomerDTO.getDescription());
        customerFromDb.setNameCompany(updateCustomerDTO.getNameCompany());
        customerFromDb.setPhone(updateCustomerDTO.getPhone());
        customerFromDb.setUpdatedAt(LocalDateTime.now());

        customerFromDb = customerRepository.save(customerFromDb);
        return customerMapper.toDTO(customerFromDb);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ID " + id + " no fue encontrado"));
        customerRepository.delete(customer);
    }
}
