package com.notes.api.service;

import com.notes.api.dto.*;
import com.notes.api.model.*;
import com.notes.api.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Autowired
    private AuthService authService;

    @Test
    void createNote_Success() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("notetest@example.com");
        registerRequest.setPassword("password123");
        authService.register(registerRequest);

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle("Test Note");
        noteRequest.setContent("Test Content");

        NoteResponse response = noteService.createNote(noteRequest, "notetest@example.com");

        assertNotNull(response);
        assertNotNull(response.getId());
        assertEquals("Test Note", response.getTitle());
        assertEquals("Test Content", response.getContent());
        assertEquals("notetest@example.com", response.getOwnerEmail());
    }

    @Test
    void createNote_UserNotFound() {
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle("Test Note");
        noteRequest.setContent("Test Content");

        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> noteService.createNote(noteRequest, "nonexistent@example.com"));
        
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void createNote_NoTitleOrContent() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("nocontent@example.com");
        registerRequest.setPassword("password123");
        authService.register(registerRequest);

        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle(null);
        noteRequest.setContent(null);

        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> noteService.createNote(noteRequest, "nocontent@example.com"));
        
        assertEquals("Title or content required", exception.getMessage());
    }
}
