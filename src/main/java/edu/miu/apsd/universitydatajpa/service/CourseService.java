package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Course;
import edu.miu.apsd.universitydatajpa.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public void saveAll(List<Course> courses) {
        repository.saveAll(courses);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Course> getAllByDepartmentNameOrderByTitle(String departmentName) {
        return repository.findAllByDepartmentNameOrderByTitle(departmentName);
    }
}
