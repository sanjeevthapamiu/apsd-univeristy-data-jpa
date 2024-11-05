package edu.miu.apsd.universitydatajpa.service;

import edu.miu.apsd.universitydatajpa.model.Course;

import java.util.List;

public interface CourseService {
    void saveAll(List<Course> courses);

    void deleteAll();

    List<Course> getAllByDepartmentNameOrderByTitle(String departmentName);
}
