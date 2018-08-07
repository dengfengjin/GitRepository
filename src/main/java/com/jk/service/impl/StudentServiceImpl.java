package com.jk.service.impl;

import com.jk.dao.DemoDaoJdbcImpl;
import com.jk.dao.StudentDao;
import com.jk.mapper.DemoMapper;
import com.jk.model.Student;
import com.jk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private DemoMapper demoMapper;

    @Resource
    private DemoDaoJdbcImpl demoDaoJdbc;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveStudent(Student stu) {
        studentDao.save(stu);
    }


    @Override
    public List<Student> queryStudent() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentDao.deleteById(id);

    }

    @Override
    public void updateStudent(Student stu) {
        studentDao.save(stu);
    }

    @Override
    public List<Student> queryStudent1() {
        return demoMapper.queryStudent1();
    }

    @Override
    public Student queryStudent2(String name) {
        return demoMapper.queryStudent2(name);
    }

    @Override
    public void saveStudent1(Student stu) {
        demoMapper.saveStudent1(stu);
    }

    @Override
    public void deleteStudent1(Integer id) {
        demoMapper.deleteStudent1(id);
    }

    @Override
    public List<Student> queryStudentJdbc() {
        return demoDaoJdbc.queryStudentJdbc();
    }

    @Override
    public void deleteStudentJdbc(Integer id) {
        demoDaoJdbc.deleteStudentJdbc(id);
    }

    @Override
    public void updateJdbc(Student stu) {
        demoDaoJdbc.updateJdbc(stu);
    }


}
