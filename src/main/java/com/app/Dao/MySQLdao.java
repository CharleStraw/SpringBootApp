package com.app.Dao;

import com.app.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mySql")
public class MySQLdao implements StudentDAO{



    private static class studentRowMaper implements RowMapper<Student>{
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setCourse(resultSet.getString("course"));
        return student;
    }}



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Student> getAllStudents() {

        final String sql ="select  id, name, course from students";
        List<Student> students = jdbcTemplate.query( sql,new studentRowMaper());

        return students;
    }

    @Override
    public Student getStudentById(int id) {
        final String sql ="select id,name,course from students where id =" + id;
        Student student =jdbcTemplate.queryForObject(sql, new studentRowMaper());

        return student;
    }

    @Override
    public void removeStudentById(int id) {
        final String sql ="delete  from students where id =?"+ id;
        jdbcTemplate.update(sql);

    }

    @Override
    public void updateStudent(Student student) {

        final String sql="UPDATE students set name=? ,course=? where  id=?";
        final int id = student.getId();
        final String name=student.getName();
        final String course=student.getCourse();
        jdbcTemplate.update(sql,new Object[]{name,course,id});



    }

    @Override
    public void insertStudent(Student student) {
        final String sql="INSERT into students (name,course) values(?,?)";
        final String name=student.getName();
        final String course=student.getCourse();
        jdbcTemplate.update(sql,new Object[]{name,course});

    }


}
