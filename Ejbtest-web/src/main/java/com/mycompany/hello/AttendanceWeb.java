/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello;

import com.mycompany.ejb.AttendanceList;
import com.mycompany.ejb.Course2;
import com.mycompany.ejb.CourseRegistry;
import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentAttendance;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private List<StudentAttendance> attendances;
    private int courseId;
    private int year;
    private int month;
    private int day;
    
    @Inject
    private CourseRegistry courseRegistry;
    @Inject 
    private AttendanceList attendanceList;
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
    
    public List<StudentAttendance> getAttendances() {
         System.out.println("getRegStudents " + courseId);
         List<Student> students = courseRegistry.getStudentsInCourse(courseId);
         attendances = attendanceList.NewAttendanceList(students);
         return attendances;
    }
    
    public void addList() {
        attendanceList.addAttendanceList(attendances, LocalDate.of(year, month, day));
    }
}
    