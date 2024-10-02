package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();
    void delete(Integer id);
}
