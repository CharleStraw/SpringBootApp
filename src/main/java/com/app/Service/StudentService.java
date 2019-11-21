package com.app.Service;

import com.app.Entity.Student;
import com.app.Dao.StudentDAO;
import java.util.Collection;

public class StudentService {


    private StudentDAO studentDao;

    public Collection<Student> getAllStudents(){

        return  studentDao.getAllStudents();


    }


}
