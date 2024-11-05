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
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Not null - no empty - no blank")
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Professor> professors;

    @OneToMany(mappedBy = "department")
    private List<Course> courses;

}
