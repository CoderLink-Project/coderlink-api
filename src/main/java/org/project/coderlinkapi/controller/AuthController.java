package org.project.coderlinkapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.coderlinkapi.model.entity.User;
import org.project.coderlinkapi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        User user = authService.login(email, password);
        return ResponseEntity.ok(user);
    }
}
