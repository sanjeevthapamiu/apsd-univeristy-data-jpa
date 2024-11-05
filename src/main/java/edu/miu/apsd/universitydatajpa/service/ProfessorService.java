package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Professor;

import java.util.List;

public interface ProfessorService {
    void deleteAll();

    List<Professor> getAllByOrderByLastName();
}
