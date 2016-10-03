/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.util.List;
import java.util.Random;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author bjorn
 */
@Singleton
public class StudentRegistryImpl implements StudentRegistry {
    static Random random = new Random();
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addStudent(String firstName, String lastName, String eMail) {
        this.em.persist(new 
        Student(random.nextInt(2048), firstName, lastName, eMail));
    }
    
    @Override
    public List<Student> getStudents() {
        Query query = em.createNamedQuery("findAllStudents");
        return query.getResultList();
    }
    
    @Override
    public List<Student> searchStudents(String str) {
        Query query = em.createNamedQuery("searchStudents"); 
        query.setParameter("firstName", str);
        return query.getResultList();
    }
}
