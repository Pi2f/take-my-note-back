package com.polytech.config;

import com.polytech.persistence.JdbcNoteRepository;
import com.polytech.persistence.NoteRepository;
import com.polytech.services.NoteService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        String url = "jdbc:mysql://localhost:3306/noteapp";
        String username = "root";
        String password = "comparator";

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NoteRepository storyRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcNoteRepository(jdbcTemplate);
    }

    @Bean
    public NoteService publicationService(NoteRepository noteRepository) {
        return new NoteService(noteRepository);
    }
}
