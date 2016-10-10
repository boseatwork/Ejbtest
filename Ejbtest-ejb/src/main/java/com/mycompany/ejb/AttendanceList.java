/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.time.LocalDate;

/**
 *
 * @author bjorn
 */
public interface AttendanceList {
    void addAttendance(LocalDate courseDate, Course course, Student student, 
            boolean present);
}
