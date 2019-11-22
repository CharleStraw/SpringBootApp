package com.app.Service;

import com.app.Entity.Student;
import com.app.Dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {




    @Autowired
    private StudentDAO studentDAO;




    public Collection<Student> getAllStudents(){

        return  studentDAO.getAllStudents();


    }

    public Student getStudentById(int id){

        return  studentDAO.getStudentById(id);

    }
}
