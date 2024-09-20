package org.project.coderlinkapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.User;
import org.project.coderlinkapi.repository.UserRepository;
import org.project.coderlinkapi.service.AuthService;
import org.project.coderlinkapi.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
}
