package com.notes.api.controller;

import com.notes.api.dto.*;
import com.notes.api.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
}
