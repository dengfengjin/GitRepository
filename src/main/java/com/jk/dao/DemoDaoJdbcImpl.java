package com.jk.dao;

import com.jk.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DemoDaoJdbcImpl {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Student> queryStudentJdbc() {
       String sql="select * from dfj_student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);


       return jdbcTemplate.query(sql,rowMapper);
    }

    public void deleteStudentJdbc(Integer id) {
        String sql="delete from dfj_student where id="+id;
        jdbcTemplate.execute(sql);

    }

    public void updateJdbc(Student stu) {
        String sql="update dfj_student set name=? where id=?";
        jdbcTemplate.update(sql,stu.getName(),stu.getId());
    }
}
