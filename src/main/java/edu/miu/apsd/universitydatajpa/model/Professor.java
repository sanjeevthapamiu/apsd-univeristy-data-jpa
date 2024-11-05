package edu.miu.apsd.universitydatajpa.model;

import jakarta.persistence.*;
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
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "professors")
    private final List<Course> courses = new ArrayList<>();



    public Professor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addCourse(Course ...courses) {
        Arrays.stream(courses).forEach(this::addCourse);
    }

    @Override
    public String toString() {
        return "\n\tProfessor{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department=" + department.getName() +
                "}";
    }
}
