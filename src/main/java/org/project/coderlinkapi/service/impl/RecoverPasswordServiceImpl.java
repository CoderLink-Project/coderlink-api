package org.project.coderlinkapi.service.impl;

import org.project.coderlinkapi.dto.RecoverPasswordDTO;
import org.project.coderlinkapi.exception.RecoverPasswordNotFoundException;
import org.project.coderlinkapi.mapper.RecoverPasswordMapper;
import org.project.coderlinkapi.model.entity.User;
import org.project.coderlinkapi.repository.RecoverPasswordRepository;
import org.project.coderlinkapi.service.RecoverPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecoverPasswordServiceImpl implements RecoverPasswordService {
    private final RecoverPasswordRepository recoverPasswordRepository;
    private final RecoverPasswordMapper recoverPasswordMapper;

    @Autowired
    public RecoverPasswordServiceImpl(RecoverPasswordRepository recoverPasswordRepository, RecoverPasswordMapper recoverPasswordMapper) {
        this.recoverPasswordRepository = recoverPasswordRepository;
        this.recoverPasswordMapper = recoverPasswordMapper;
    }

    @Override
    public void recoverPassword(RecoverPasswordDTO recoverPasswordDTO) {
        String email = recoverPasswordDTO.getEmail();
        recoverPasswordRepository.findByEmail(email)
                .orElseThrow(() -> new RecoverPasswordNotFoundException("Email not found"));

        // Lógica para generar el token y enviar el correo
        String resetToken = generateResetToken();
        sendResetEmail(email, resetToken);
    }

    private String generateResetToken() {
        // Lógica para generar un token de restablecimiento
        return UUID.randomUUID().toString();
    }

    private void sendResetEmail(String email, String resetToken) {
        // Lógica para enviar el correo con el enlace o código de restablecimiento
        System.out.println("Email sent to " + email + " with reset token: " + resetToken);
    }
}
