package com.jk.controller;

import com.jk.model.Student;
import com.jk.service.StudentService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("stu")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * jpa新增
     */
    @RequestMapping("save")
    @ResponseBody
    public void saveStudent(){
        Student stu=new Student();
        stu.setName("zhang");
        stu.setSex("nv");
        studentService.saveStudent(stu);

    }

    /**
     * jpa查询
     * @return
     */
    @RequestMapping("query")
    @ResponseBody
    public List<Student> queryStudent(){

        List<Student> list=studentService.queryStudent();
        return list;
    }


    /**
     * jpa删除
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public String deleteStudent(){
        Integer id=1;
        studentService.deleteStudent(id);
        return "1";
    }

    /**
     * jpa修改
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String updateStudent() {
        Student stu=new Student();
        stu.setId(1);
        stu.setName("zhang");
        stu.setSex("nv");
        studentService.updateStudent(stu);
        return "1";
    }


    /**
     * mybatis查询
     * @return
     */
    @RequestMapping("queryStudent1")
    @ResponseBody
    public List<Student> queryStudent1(){

        List<Student> list = studentService.queryStudent1();
        return list;
    }
    /**
     * mybatis查询+条件查询
     * @return
     */
    @RequestMapping("queryStudent2")
    @ResponseBody
    public Student queryStudent2(String name){
         name="11";
        Student stu = studentService.queryStudent2(name);
        return stu;
    }

    /**
     * mybatis新增
     * @return
     */
    @RequestMapping("saveStudent1")
    @ResponseBody
    public String saveStudent1(){
        Student stu=new Student();

        stu.setName("李四");
        stu.setSex("男");
        studentService.saveStudent1(stu);
        return "1";
    }

    /**
     * mybatis删除
     * @param id
     * @return
     */
    @RequestMapping("deleteStudent1")
    @ResponseBody
    public String deleteStudent1(Integer id){

        studentService.deleteStudent1(id);
        return "1";
    }

    /**
     * jdbctemplate查询
     * @return
     */
    @RequestMapping("queryStudentJdbc")
    @ResponseBody
    public List<Student> queryStudentJdbc(){
        List<Student> list = studentService.queryStudentJdbc();
        return list;
    }

    @ResponseBody
    @RequestMapping("deleteStudentJdbc")
    public String deleteStudentJdbc(Integer id){

        studentService.deleteStudentJdbc(id);
        return "1";
    }

    /**
     * redis存值
     * @return
     */
    @ResponseBody
    @RequestMapping("setredis")
    public String setredis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Student stu=new Student();
        stu.setId(2);
        stu.setName("王五");
        stu.setSex("男");
        valueOperations.set("1801",stu);
        return "1";
    }


    /**
     * redis取值
     * @return
     */
    @ResponseBody
    @RequestMapping("getredis")
    public Student getredis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Student stu = (Student) valueOperations.get("1801");

        return stu;
    }

    /**
     * 存入mongodb
     * @return
     */
    @ResponseBody
    @RequestMapping("setmongodb")
    public String setmongodb(){
        Student stu=new Student();
        stu.setId(1);
        stu.setName("李四");
        stu.setSex("男");
        mongoTemplate.save(stu);

        return "1";
    }

    @ResponseBody
    @RequestMapping("updateJdbc")
    public String updateJdbc(){
        Student stu=new Student();
        stu.setId(3);
        stu.setName("王五");
        studentService.updateJdbc(stu);
        return "1";
    }




}
