package org.project.coderlinkapi.service.impl;
import org.project.coderlinkapi.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.Developer;
import org.project.coderlinkapi.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Override
    public List<Developer> searchDevelopersBySkill(String skill) {
        return developerRepository.findBySkillSetContaining(skill);
    }
}
