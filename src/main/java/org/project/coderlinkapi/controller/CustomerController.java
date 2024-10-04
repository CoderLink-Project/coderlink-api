package org.project.coderlinkapi.controller;

import org.project.coderlinkapi.dto.CustomerDTO;
import org.project.coderlinkapi.model.entity.Customer;
import org.project.coderlinkapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
@PreAuthorize("hasRole('ADMIN')")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listAll() {
        List<CustomerDTO> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<CustomerDTO>> paginate(@PageableDefault(size = 5, sort = "firstName")
                                                    Pageable pageable) {
        Page<CustomerDTO> page = customerService.paginate(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Integer id) {
        CustomerDTO customer = customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Integer id,@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.update(id, customerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
