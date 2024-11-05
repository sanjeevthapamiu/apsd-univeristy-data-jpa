package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Professor;
import edu.miu.apsd.universitydatajpa.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;
    private final JdbcTemplate jdbcTemplate;

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM course_professors");
        repository.deleteAll();
    }

    public List<Professor> getAllByOrderByLastName() {
        return repository.findAllByOrderByLastName();
    }
}
