package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.repository.CustomerRepository;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setFirstname(updatedCustomer.getFirstname());
        existingCustomer.setLastname(updatedCustomer.getLastname());
        existingCustomer.setDni(updatedCustomer.getDni());
        existingCustomer.setNameCompany(updatedCustomer.getNameCompany());
        existingCustomer.setRuc(updatedCustomer.getRuc());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        return customerRepository.save(existingCustomer);
    }
}
