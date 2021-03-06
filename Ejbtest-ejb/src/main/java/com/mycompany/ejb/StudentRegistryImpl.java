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
    public void addStudent(String firstName, String lastName, String email) {
        this.em.persist(new 
        Student(random.nextInt(2048), firstName, lastName, email));
    }
    
    @Override
    public void change(int id, String firstName, String lastName, 
            String email) {
        Student student = this.em.find(Student.class, id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        this.em.merge(student);
    }
    
    @Override
    public void removeStudent(int studentId) {
        System.out.println("Almost success:" + studentId);
        Student student = this.em.find(Student.class, studentId);
        this.em.remove(student);
    }
    
    @Override
    public List<Student> getStudents() {
        Query query = em.createNamedQuery("findAllStudents");
        return query.getResultList();
    }
    
    @Override
    public Student getFromDB(int studentId) {
        return this.em.find(Student.class, studentId);
    }
    
    @Override
    public List<Student> exactMatch(String str1, String str2) {
        Query query = em.createNamedQuery("exactMatch");
        query.setParameter("firstName", str1);
        query.setParameter("lastName", str2);
        return query.getResultList();
    }
    
    @Override
    public List<Student> searchStudents(String str1, String str2) {
        Query query = em.createNamedQuery("searchStudents"); 
        query.setParameter("firstName", str1);
        query.setParameter("lastName", str2);
        return query.getResultList();
    }
}
