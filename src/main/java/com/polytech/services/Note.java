package com.polytech.services;

import java.util.Objects;

public class Note {
    private int id;
    private String title;
    private String data;

    public Note() {
    }

    public Note(int id, String title, String data) {
        this.id = id;
        this.title = title;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note Note = (Note) o;
        return Objects.equals(data, Note.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }
}
