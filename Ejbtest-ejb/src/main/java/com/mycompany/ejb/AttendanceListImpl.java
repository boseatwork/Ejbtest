/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bjorn
 */
@Singleton
public class AttendanceListImpl implements AttendanceList {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<StudentAttendance> NewAttendanceList(List<Student> students) {
        List<StudentAttendance> attendances = new ArrayList<>();
        for (Student x: students) attendances.add(new StudentAttendance(x));
        return attendances;
    }
    
    @Override
    public void addAttendanceList(List<StudentAttendance> attendances,
            LocalDate courseDate) {
        this.em.persist(new AttendanceLists(attendances, courseDate));
    }
    
}
