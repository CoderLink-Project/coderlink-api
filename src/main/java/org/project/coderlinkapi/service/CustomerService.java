package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();
    Page<CustomerDTO> paginate(Pageable pageable);
    CustomerDTO findById(Integer id);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(Integer id, CustomerDTO updateCustomerDTO);
    void delete(Integer id);
}
