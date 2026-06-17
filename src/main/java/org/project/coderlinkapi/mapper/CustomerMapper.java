package org.project.coderlinkapi.mapper;

import org.project.coderlinkapi.dto.CustomerDTO;
import org.project.coderlinkapi.model.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public CustomerDTO toDTO (Customer customer){
        return  modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer toEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, Customer.class);
    }
}

