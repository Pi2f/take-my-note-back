package com.polytech.web;

import com.polytech.services.Note;
import com.polytech.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotesRestController {

    private NoteService noteService;

    public NotesRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/api/notes", method = RequestMethod.GET)
    public List<Note> notes() {
        List<Note> notes = noteService.get();
        return notes;
    }

    @RequestMapping(value = "/api/notes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Note post(@RequestBody Note note) {
        noteService.add(note);
        return note;
    }

    @RequestMapping(value = "/api/notes", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Note note) {
        noteService.update(note);
    }

    @RequestMapping(value = "/api/notes/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        noteService.delete(id);
    }
}
