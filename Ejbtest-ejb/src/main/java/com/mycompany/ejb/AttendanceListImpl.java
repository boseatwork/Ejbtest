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
    public void addAttendance(LocalDate courseDate, Course course, 
            Student student, boolean present) {
        this.em.persist(new AttendanceLists(courseDate, course, student, 
                present));
    }
    
}
