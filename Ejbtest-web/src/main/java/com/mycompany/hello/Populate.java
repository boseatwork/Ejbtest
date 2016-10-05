/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello;

import com.mycompany.ejb.RegStudentCourse;
import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentRegistry;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author User
 */
@ManagedBean
@Named(value="populate")
@SessionScoped
public class Populate implements Serializable {
    private String firstName;
    private String lastName;
    private int courseCode;
    private List<Course> courses;
    
    //@EJB
    //private CourseRegistry courseRegistry;
    @EJB
    private StudentRegistry studentRegistry;
    @EJB
    private RegStudentCourse regStudentCourse;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
    
    public void setCourses() { 
        courses = courseRegistry.getCourses();
    }
    
    public void registerStudent() {
        Student student = studentRegistry.exactMatch(firstName, lastName);
        regStudentCourse.addEntry(student.getId(), courseCode);
    }
}
