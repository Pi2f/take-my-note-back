package com.polytech.persistence;

import com.polytech.services.Note;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcNoteRepository implements NoteRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcNoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Note> get() {
        String query = "SELECT * FROM note";
        return jdbcTemplate.query(query, new NoteMapper());
    }

    @Override
    public void add(Note note) {
        String query = "INSERT INTO note (ID,TITLE,DATA)VALUES(?,?,?)";
        jdbcTemplate.update(query, note.getId(), note.getTitle(),note.getData());
    }

    @Override
    public void update(Note note) {
        String query = "UPDATE note " +
                "SET data = ? " +
                "WHERE id = ?;";
        jdbcTemplate.update(query, note.getData(), note.getId());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM note WHERE id = ?";
        jdbcTemplate.update(query,id);
    }

    class NoteMapper implements RowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String data = rs.getString("DATA");
            return new Note(id,title,data);
        }
    }
}
