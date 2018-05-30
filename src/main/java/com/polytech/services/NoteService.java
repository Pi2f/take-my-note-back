package com.polytech.services;

import com.polytech.persistence.NoteRepository;

import java.util.List;


public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> get() {
        return noteRepository.get();
    }

    public void add(Note note) {
        noteRepository.add(note);
    }

    public void update(Note note) {
         noteRepository.update(note);
    }

    public void delete(int id) {
        noteRepository.delete(id);
    }
}
