package com.frankbearzou.jdbctemplate;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    public void create(String name, int age);
    public Student getStudent(int id);
    public List<Student> listStudents();
}
