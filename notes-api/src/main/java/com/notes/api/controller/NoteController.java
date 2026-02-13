package com.notes.api.controller;

import com.notes.api.dto.*;
import com.notes.api.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest request, Authentication auth) {
        String email = auth.getName();
        return ResponseEntity.ok(noteService.createNote(request, email));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getUserNotes(Authentication auth) {
        String email = auth.getName();
        return ResponseEntity.ok(noteService.getUserNotes(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable Long id, 
                                                     @Valid @RequestBody NoteRequest request, 
                                                     Authentication auth) {
        String email = auth.getName();
        return ResponseEntity.ok(noteService.updateNote(id, request, email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNote(@PathVariable Long id, Authentication auth) {
        String email = auth.getName();
        noteService.deleteNote(id, email);
        return ResponseEntity.ok(Map.of("message", "Note deleted successfully"));
    }
}
