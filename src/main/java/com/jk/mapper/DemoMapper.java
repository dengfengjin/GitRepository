package com.jk.mapper;

import com.jk.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DemoMapper {

    @Select("select * from dfj_student ")
    List<Student> queryStudent1();

    @Select("select * from dfj_student where name=#{name} ")
    Student queryStudent2(@Param("name") String name);

    @Insert("insert into dfj_student values(#{id},#{name},#{sex})")
    void saveStudent1(Student stu);

    @Delete("delete from dfj_student where id=#{id}")
    void deleteStudent1(@Param("id") Integer id);
}
