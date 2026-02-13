package com.notes.api.service;

import com.notes.api.dto.*;
import com.notes.api.model.*;
import com.notes.api.repository.*;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public NoteResponse createNote(NoteRequest request, String email) {
        if (request.getTitle() == null && request.getContent() == null) {
            throw new RuntimeException("Title or content required");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setUser(user);
        
        Note saved = noteRepository.save(note);
        return new NoteResponse(saved.getId(), saved.getTitle(), saved.getContent(), user.getEmail());
    }
}
