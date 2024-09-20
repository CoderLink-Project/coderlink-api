package org.project.coderlinkapi.service;
import org.project.coderlinkapi.model.entity.Developer;
import java.util.List;

public interface DeveloperService {
    List<Developer> searchDevelopersBySkill(String skill);
}
