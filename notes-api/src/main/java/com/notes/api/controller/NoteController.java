package com.notes.api.controller;

import com.notes.api.dto.*;
import com.notes.api.service.NoteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest request, Authentication auth) {
        String email = auth.getName();
        logger.info("Creating note for user: {}", email);
        NoteResponse response = noteService.createNote(request, email);
        logger.info("Note created with ID: {} for user: {}", response.getId(), email);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getUserNotes(Authentication auth) {
        String email = auth.getName();
        logger.info("Fetching notes for user: {}", email);
        List<NoteResponse> notes = noteService.getUserNotes(email);
        logger.info("Retrieved {} notes for user: {}", notes.size(), email);
        return ResponseEntity.ok(notes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable Long id, 
                                                     @Valid @RequestBody NoteRequest request, 
                                                     Authentication auth) {
        String email = auth.getName();
        logger.info("Updating note ID: {} for user: {}", id, email);
        NoteResponse response = noteService.updateNote(id, request, email);
        logger.info("Note ID: {} updated successfully for user: {}", id, email);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNote(@PathVariable Long id, Authentication auth) {
        String email = auth.getName();
        logger.info("Deleting note ID: {} for user: {}", id, email);
        noteService.deleteNote(id, email);
        logger.info("Note ID: {} deleted successfully for user: {}", id, email);
        return ResponseEntity.ok(Map.of("message", "Note deleted successfully"));
    }
}
