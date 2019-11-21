package com.app.Controller;

import com.app.Entity.Student;
import com.app.Service.StudentService;
import java.util.Collection;

public class StudentController {

    private StudentService studentService;


    public Collection<Student> getAllStudents(){

        return  studentService.getAllStudents();


    }
}
