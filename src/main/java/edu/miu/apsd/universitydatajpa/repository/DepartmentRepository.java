package edu.miu.apsd.universitydatajpa.repository;

import edu.miu.apsd.universitydatajpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAllByOrderByName();

}
