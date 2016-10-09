/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author bjorn
 */
public interface AttendanceList {
    List<StudentAttendance> NewAttendanceList(List<Student> students);
    void addAttendanceList(List<StudentAttendance> attendances, 
            LocalDate courseDate);
}
