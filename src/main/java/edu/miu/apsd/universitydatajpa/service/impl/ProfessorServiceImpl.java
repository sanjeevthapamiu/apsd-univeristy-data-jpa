package edu.miu.apsd.universitydatajpa.service.impl;

import edu.miu.apsd.universitydatajpa.model.Professor;
import edu.miu.apsd.universitydatajpa.repository.ProfessorRepository;
import edu.miu.apsd.universitydatajpa.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository repository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM course_professors");
        repository.deleteAll();
    }

    @Override
    public List<Professor> getAllByOrderByLastName() {
        return repository.findAllByOrderByLastName();
    }
}
