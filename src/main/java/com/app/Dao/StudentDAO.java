package com.app.Dao;

import com.app.Entity.Student;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;


//@Component is a generic stereotype for any Spring-managed component
//@Service annotates classes at the service layer
//@Repository annotates classes at the persistence layer, which will act as a database repository
//@Controller is a common annotation which is used to mark a class as Spring MVC

@Repository
public class StudentDAO {


    private static HashMap<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>() {

            {

                put(1, new Student(1, "Said", "Computer Sciencee"));
                put(2, new Student(2, "Karol", "Finance"));
                put(3, new Student(3, "Mark", "Programing and Testing"));
            }


        };


    }


    public Collection<Student> getAllStudents() {

        return this.students.values();


    }

    public Student getStudentById(int id){

        return  this.students.get(id);


    }
}
