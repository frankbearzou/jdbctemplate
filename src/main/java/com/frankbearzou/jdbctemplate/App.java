package com.frankbearzou.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
//        studentDAO.create("Frank", 30);
//        studentDAO.create("Timothy", 3);
//        studentDAO.create("Mark", 1);

//        Student student = studentDAO.getStudent(1);
//        System.out.println(student);

        List<Student> students = studentDAO.listStudents();
        System.out.println(students);

        System.out.println("finished");
    }
}
