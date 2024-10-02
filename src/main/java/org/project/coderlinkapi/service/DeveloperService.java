package org.project.coderlinkapi.service;

import org.project.coderlinkapi.dto.DeveloperDTO;


import java.util.List;

public interface DeveloperService {
    List<DeveloperDTO> getAll();
    void delete(Integer id);
}
