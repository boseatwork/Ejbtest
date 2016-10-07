/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello;

import com.mycompany.ejb.Course2;
import com.mycompany.ejb.CourseRegistry;
import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentRegistry;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named(value="populate")
@SessionScoped
public class Populate implements Serializable {
    private String firstName;
    private String lastName;
    private String errorMessage = "";
    private int courseCode;
    private List<Course2> courses;
    private List<Student> regStudents;
    
    @EJB
    private CourseRegistry courseRegistry;
    @EJB
    private StudentRegistry studentRegistry;

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
    
    public List<Course2> getCourses() {
        courses = courseRegistry.getCourses();
        return courses;
    }

    public List<Student> getRegStudents() {
         System.out.println("getRegStudents " + courseCode);
         regStudents = courseRegistry.getStudentsInCourse(courseCode);
         return regStudents;
    }

     public void registerStudent() {
        List<Student> students = studentRegistry.exactMatch(firstName, lastName);
        if (courseRegistry.getFromDB(courseCode)==null) {
            errorMessage = "No course with this id in database";
            return;
        }
        switch(students.size()) {
            case 0:
                errorMessage = "No such student in the database";
                break;
            case 1:
                courseRegistry.addStudentToCourse(courseCode, students.get(0));
                break;
            default:
                errorMessage = "The name does not uniquely identify a student";
                break;
        }
     }
}
