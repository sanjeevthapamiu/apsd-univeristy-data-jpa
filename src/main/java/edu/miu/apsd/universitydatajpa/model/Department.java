package edu.miu.apsd.universitydatajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Not null - no empty - no blank")
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.ALL})
    private final List<Professor> professors = new ArrayList<>();

    @OneToMany(mappedBy = "department", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private final List<Course> courses = new ArrayList<>();



    public Department(String name) {
        this.name = name;
    }

    public void addProfessor(Professor professor) {
        professor.setDepartment(this);
        professors.add(professor);
    }

    public void addProfessor(Professor ...professors) {
        Arrays.stream(professors).forEach(this::addProfessor);
    }

    public void addCourse(Course course) {
        course.setDepartment(this);
        courses.add(course);
    }

    public void addCourse(Course ...courses) {
        Arrays.stream(courses).forEach(this::addCourse);
    }

    @Override
    public String toString() {
        return "\n\tDepartment{" +
                "departmentName='" + name + '\'' +
                ", courseName=" + courses.stream().map(Course::getTitle).toList() +
                '}';
    }
}
