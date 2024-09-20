package org.project.coderlinkapi.service;

import org.project.coderlinkapi.model.entity.User;

public interface AuthService {
    User login(String email, String password);
}
