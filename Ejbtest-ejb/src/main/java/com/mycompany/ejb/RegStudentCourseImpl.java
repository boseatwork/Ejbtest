/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Singleton
public class RegStudentCourseImpl implements RegStudentCourse {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addEntry(int studentId, int courseId) {
        this.em.persist(new StudentCourse(studentId, courseId));
    }
}
