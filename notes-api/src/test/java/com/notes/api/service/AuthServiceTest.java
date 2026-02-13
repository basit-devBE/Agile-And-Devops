package com.notes.api.service;

import com.notes.api.dto.*;
import com.notes.api.model.User;
import com.notes.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void register_Success() {
        RegisterRequest request = new RegisterRequest();
        request.setEmail("test@example.com");
        request.setPassword("password123");

        AuthResponse response = authService.register(request);

        assertNotNull(response);
        assertNotNull(response.getToken());
        assertEquals("test@example.com", response.getEmail());
        assertTrue(userRepository.existsByEmail("test@example.com"));
    }

    @Test
    void register_EmailAlreadyExists() {
        RegisterRequest request = new RegisterRequest();
        request.setEmail("duplicate@example.com");
        request.setPassword("password123");

        authService.register(request);

        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> authService.register(request));
        
        assertEquals("Email already exists", exception.getMessage());
    }

    @Test
    void login_Success() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("logintest@example.com");
        registerRequest.setPassword("password123");
        authService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("logintest@example.com");
        loginRequest.setPassword("password123");

        AuthResponse response = authService.login(loginRequest);

        assertNotNull(response);
        assertNotNull(response.getToken());
        assertEquals("logintest@example.com", response.getEmail());
    }

    @Test
    void login_InvalidCredentials_UserNotFound() {
        LoginRequest request = new LoginRequest();
        request.setEmail("nonexistent@example.com");
        request.setPassword("password123");

        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> authService.login(request));
        
        assertEquals("Invalid credentials", exception.getMessage());
    }

    @Test
    void login_InvalidCredentials_WrongPassword() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("wrongpass@example.com");
        registerRequest.setPassword("correctpassword");
        authService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("wrongpass@example.com");
        loginRequest.setPassword("wrongpassword");

        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> authService.login(loginRequest));
        
        assertEquals("Invalid credentials", exception.getMessage());
    }
}
