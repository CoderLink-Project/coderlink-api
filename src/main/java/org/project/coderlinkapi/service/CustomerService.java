package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    CustomerDTO setProjectMilestone(int projectId, CustomerDTO customerDTO);
    List<CustomerDTO> getProjectMilestone(int projectId);
    void delete(Integer id);
}
