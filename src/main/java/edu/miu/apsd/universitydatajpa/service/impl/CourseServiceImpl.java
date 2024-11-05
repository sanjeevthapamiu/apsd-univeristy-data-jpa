package edu.miu.apsd.universitydatajpa.service.impl;

import edu.miu.apsd.universitydatajpa.model.Course;
import edu.miu.apsd.universitydatajpa.repository.CourseRepository;
import edu.miu.apsd.universitydatajpa.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    @Override
    public void saveAll(List<Course> courses) {
        repository.saveAll(courses);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Course> getAllByDepartmentNameOrderByTitle(String departmentName) {
        return repository.findAllByDepartmentNameOrderByTitle(departmentName);
    }
}
