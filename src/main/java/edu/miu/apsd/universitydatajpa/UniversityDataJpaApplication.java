package edu.miu.apsd.universitydatajpa;

import edu.miu.apsd.universitydatajpa.model.Course;
import edu.miu.apsd.universitydatajpa.model.Department;
import edu.miu.apsd.universitydatajpa.model.Professor;
import edu.miu.apsd.universitydatajpa.service.CourseService;
import edu.miu.apsd.universitydatajpa.service.DepartmentService;
import edu.miu.apsd.universitydatajpa.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class UniversityDataJpaApplication {

    private final ProfessorService professorService;
    private final CourseService courseService;
    private final DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            reset();
            saveData();

            System.out.println(professorService.getAllByOrderByLastName() + "\n");
            System.out.println(courseService.getAllByDepartmentNameOrderByTitle("Computer Science") + "\n");
            System.out.println(departmentService.getAllByOrderByName() + "\n");
        };
    }


    private void reset() {
        professorService.deleteAll();
        departmentService.deleteAll();
        courseService.deleteAll();
    }

    private void saveData() {
        Professor alice = new Professor("Alice", "Smith");
        Professor john = new Professor("John", "Doe");
        Professor emma = new Professor("Emma", "Johnson");
        Professor daniel = new Professor("Daniel", "Lee");

        Department computerScience = new Department("Computer Science");
        Department mathematics = new Department("Mathematics");
        Department physics = new Department("Physics");

        Course dataStructures = new Course("Data Structures");
        Course algorithms = new Course("Algorithms");
        Course operatingSystems = new Course("Operating Systems");
        Course calculus = new Course("Calculus");
        Course linearAlgebra = new Course("Linear Algebra");
        Course mechanics = new Course("Mechanics");
        Course quantumPhysics = new Course("Quantum Physics");

        // Department, Professor Relationship
        computerScience.addProfessor(alice, daniel);
        mathematics.addProfessor(john);
        physics.addProfessor(emma);

        // Department, Course Relationship
        computerScience.addCourse(dataStructures, algorithms, operatingSystems);
        mathematics.addCourse(calculus, linearAlgebra);
        physics.addCourse(mechanics, quantumPhysics);

        // Professor, Course Relationship
        dataStructures.addProfessor(alice, daniel);
        algorithms.addProfessor(alice);
        operatingSystems.addProfessor(daniel);
        calculus.addProfessor(john);
        linearAlgebra.addProfessor(john);
        mechanics.addProfessor(emma);
        quantumPhysics.addProfessor(emma);

        departmentService.saveAll(List.of(computerScience, mathematics, physics));
        courseService.saveAll(List.of(dataStructures, algorithms, operatingSystems, calculus, linearAlgebra, mechanics, quantumPhysics));
    }

}
