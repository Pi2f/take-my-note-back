package com.polytech.persistence;

import com.polytech.services.Note;
import java.util.List;

public interface NoteRepository {


    void add(Note content);
    void update(Note note);
    void delete(int id);
    List<Note> get();
}
