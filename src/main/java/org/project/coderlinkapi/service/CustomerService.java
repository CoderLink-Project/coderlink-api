package org.project.coderlinkapi.service;
import org.project.coderlinkapi.model.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, Customer updatedCustomer);

    Customer createCustomer(Customer customer);
}
