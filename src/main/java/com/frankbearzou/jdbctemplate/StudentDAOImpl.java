package com.frankbearzou.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private static final String INSERT_SQL = "insert into student(name, age) values(?, ?)";
    private static final String GET_SQL = "select * from student where id=?";
    private static final String LIST_SQL = "select * from student";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String name, int age) {
        jdbcTemplate.update(INSERT_SQL, name, age);
    }

    public Student getStudent(int id) {
        Student student = jdbcTemplate.queryForObject(GET_SQL, new Object[]{id}, new StudentRowMapper());
        return student;
    }

    public List<Student> listStudents() {
        List<Student> students = jdbcTemplate.query(LIST_SQL, new StudentRowMapper());
        return students;
    }
}

class StudentRowMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
