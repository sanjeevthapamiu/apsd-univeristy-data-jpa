package edu.miu.apsd.universitydatajpa.repository;

import edu.miu.apsd.universitydatajpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByDepartmentNameOrderByTitle(String departmentName);

}
