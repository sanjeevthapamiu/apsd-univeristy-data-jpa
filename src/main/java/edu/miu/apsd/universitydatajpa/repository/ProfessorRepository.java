package edu.miu.apsd.universitydatajpa.repository;

import edu.miu.apsd.universitydatajpa.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
