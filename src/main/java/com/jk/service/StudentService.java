package com.jk.service;

import com.jk.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student stu);

    List<Student> queryStudent();

    void deleteStudent(Integer id);

    void updateStudent(Student stu);

    List<Student> queryStudent1();

    Student queryStudent2(String name);

    void saveStudent1(Student stu);

    void deleteStudent1(Integer id);

    List<Student> queryStudentJdbc();

    void deleteStudentJdbc(Integer id);

    void updateJdbc(Student stu);
}
