/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello;

import com.mycompany.ejb.Course2;
import com.mycompany.ejb.CourseRegistry;
import com.mycompany.ejb.Student;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bjorn
 */
@Named(value="aW")
@SessionScoped
public class AttendanceWeb implements Serializable {
    private List<Course2> courses;
    private List<Student> regStudents;
    private int courseId;
    
    @Inject
    private CourseRegistry courseRegistry;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public CourseRegistry getCourseRegistry() {
        return courseRegistry;
    }

    public void setCourseRegistry(CourseRegistry courseRegistry) {
        this.courseRegistry = courseRegistry;
    }
    
    public List<Course2> getCourses() {
        courses = courseRegistry.getCourses();
        return courses;
    }
    
    public List<Student> getRegStudents() {
         System.out.println("getRegStudents " + courseId);
         regStudents = courseRegistry.getStudentsInCourse(courseId);
         return regStudents;
    }
    
}
    