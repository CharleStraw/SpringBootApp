package com.app.Service;

import com.app.Dao.MySQLdao;
import com.app.Entity.Student;
import com.app.Dao.StudentDAOmongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {


    @Autowired
    private MySQLdao mySQLdao;


    public Collection<Student> getAllStudents() {

        return mySQLdao.getAllStudents();


    }

    public Student getStudentById(int id) {

        return mySQLdao.getStudentById(id);

    }

    public void deleteStudentByiD(int id) {
         mySQLdao.removeStudentById(id);
    }

    public void updateStudent(Student student) {


        this.mySQLdao.updateStudent(student);

    }


    public void insertStudent(Student student) {
        this.mySQLdao.insertStudent(student);
    }
}
