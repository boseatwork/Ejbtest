/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author bjorn
 */
@Entity
public class AttendanceLists implements Serializable {
    private List<StudentAttendance> attendances;
    private LocalDate courseDate;
    @Id
    private int id;
    
    public AttendanceLists() {}
    
    public AttendanceLists(List<StudentAttendance> attendances, 
            LocalDate courseDate) {
        this.attendances = attendances;
        this.courseDate = courseDate;
    }

    public List<StudentAttendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<StudentAttendance> attendances) {
        this.attendances = attendances;
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
