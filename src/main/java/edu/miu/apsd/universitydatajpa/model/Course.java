package edu.miu.apsd.universitydatajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Not null - no empty - no blank")
    @Column(nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name = "course_professors",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Professor> professors;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
