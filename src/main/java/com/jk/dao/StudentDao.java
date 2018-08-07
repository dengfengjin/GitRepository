package com.jk.dao;

import com.jk.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface StudentDao extends JpaRepository<Student,Serializable>{
}
