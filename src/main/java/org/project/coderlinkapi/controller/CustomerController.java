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

@RestController
@RequestMapping("/api/v1/customers")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listAll() {
        List<CustomerDTO> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    // Obtener clientes paginados
    @GetMapping("/page")
    public ResponseEntity<Page<CustomerDTO>> paginate(@PageableDefault(size = 5, sort = "firstName") Pageable pageable) {
        Page<CustomerDTO> page = customerService.paginate(pageable);
        return ResponseEntity.ok(page);
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Integer id) {
        CustomerDTO customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    // Actualizar un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Integer id, @Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.update(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

