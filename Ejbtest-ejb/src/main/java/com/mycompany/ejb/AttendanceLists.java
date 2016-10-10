/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author bjorn
 */
@Entity
public class AttendanceLists implements Serializable {
    private LocalDate courseDate;
    boolean present;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
    @Id
    private int id;
    
    public AttendanceLists() {}
    
    public AttendanceLists(LocalDate courseDate, Course course, 
            Student student, boolean present) {
        this.courseDate = courseDate;
        this.course = course;
        this.student = student;
        this.present = present;
    }

    public LocalDate getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(LocalDate courseDate) {
        this.courseDate = courseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
