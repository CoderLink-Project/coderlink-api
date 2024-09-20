package org.project.coderlinkapi.service;

public interface UserService {
    void changePassword(Long userId, String oldPassword, String newPassword);
}
