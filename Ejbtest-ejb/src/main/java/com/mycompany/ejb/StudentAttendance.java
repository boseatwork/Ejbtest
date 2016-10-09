/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.io.Serializable;

/**
 *
 * @author bjorn
 */
public class StudentAttendance implements Serializable {
    private Student student;
    private boolean present;
    
    public StudentAttendance() {};
    
    public StudentAttendance(Student student) {
        this.student = new Student(student);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
    
    
    
}
