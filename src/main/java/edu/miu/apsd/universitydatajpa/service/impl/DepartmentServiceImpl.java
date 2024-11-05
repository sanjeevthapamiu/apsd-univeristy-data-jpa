package edu.miu.apsd.universitydatajpa.service.impl;

import edu.miu.apsd.universitydatajpa.model.Department;
import edu.miu.apsd.universitydatajpa.repository.DepartmentRepository;
import edu.miu.apsd.universitydatajpa.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public void saveAll(List<Department> departments) {
        repository.saveAll(departments);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Department> getAllByOrderByName() {
        return repository.findAllByOrderByName();
    }
}
