package com.notes.api.service;

import com.notes.api.dto.*;
import com.notes.api.model.*;
import com.notes.api.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<NoteResponse> getUserNotes(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return noteRepository.findByUserId(user.getId()).stream()
                .map(note -> new NoteResponse(note.getId(), note.getTitle(), note.getContent(), email))
                .collect(Collectors.toList());
    }

    public NoteResponse updateNote(Long id, NoteRequest request, String email) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if (!note.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Not authorized to update this note");
        }

        if (request.getTitle() != null) {
            note.setTitle(request.getTitle());
        }
        if (request.getContent() != null) {
            note.setContent(request.getContent());
        }

        Note updated = noteRepository.save(note);
        return new NoteResponse(updated.getId(), updated.getTitle(), updated.getContent(), email);
    }

    public void deleteNote(Long id, String email) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if (!note.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Not authorized to delete this note");
        }

        noteRepository.delete(note);
    }
}
