package org.project.coderlinkapi.exception;

public class DeveloperNotFoundException extends RuntimeException {
    public DeveloperNotFoundException() {}
    public DeveloperNotFoundException(String message) {
        super(message);
    }
}
