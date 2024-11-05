package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Department;

import java.util.List;

public interface DepartmentService {
    void saveAll(List<Department> departments);

    void deleteAll();

    List<Department> getAllByOrderByName();
}
