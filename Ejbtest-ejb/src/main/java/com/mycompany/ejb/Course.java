/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author bjorn
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name="findAllCourses",
            query="select b from Course b"
    ),
    @NamedQuery(
            name="searchCourses",
            query="select b from Course b where b.name = :name"
                    + " or b.code = :code"
    )
})

public class Course implements Serializable {
    private String name;
    private String code;
    private String level;
    private String language;
    private String teacher;
    @Id 
    private int id;
    @ManyToMany
    private List<Student> studentCollection;

    public Course() {
    }

    public Course(Course course) {
        this.id = course.id;
        this.name = course.name;
        this.code = course.code;
        this.level = course.level; 
        this.language = course.language;
        this.teacher = course.teacher;
        
    }
    
    Course(int id, String name, String code, String level, String language, String teacher) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.level = level; 
        this.language = language;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    
    public void addStudent(Student student) {
        studentCollection.add(student);
    }

    public List<Student> getStudentCollection() {
        return studentCollection;
    }
    
    
}