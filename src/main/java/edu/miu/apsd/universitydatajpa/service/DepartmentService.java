package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Department;
import edu.miu.apsd.universitydatajpa.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public void saveAll(List<Department> departments) {
        repository.saveAll(departments);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Department> getAllByOrderByName() {
        return repository.findAllByOrderByName();
    }
}
