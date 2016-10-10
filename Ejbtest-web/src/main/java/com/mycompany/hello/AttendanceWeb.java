/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hello;

import com.mycompany.ejb.AttendanceList;
import com.mycompany.ejb.Course;
import com.mycompany.ejb.CourseRegistry;
import com.mycompany.ejb.Student;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
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
    private List<Course> courses;
    private List<StudentAttendance> attendances;
    private int courseId;
    private int year;
    private int month;
    private int day;
    
    @EJB
    private CourseRegistry courseRegistry;
    @EJB 
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
    
    public List<Course> getCourses() {
        courses = courseRegistry.getCourses();
        return courses;
    }
    
    public List<StudentAttendance> getAttendances() {
         System.out.println("getRegStudents " + courseId);
         List<Student> students = courseRegistry.getStudentsInCourse(courseId);
         for (Student x: students) 
             attendances.add(new StudentAttendance(x));
         return attendances;
    }
    
    public void addList() {
        LocalDate courseDate = LocalDate.of(year, month, day);
        for (StudentAttendance x: attendances) 
            attendanceList.addAttendance(courseDate, 
                    courseRegistry.getFromDB(courseId),
                    x.getStudent(), x.isPresent());
    }
}

    