/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.util.ArrayList;
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
public class CourseRegistryImpl implements CourseRegistry {
    static Random random = new Random();
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCourse(String name, String code, String level, String language, String teacher) {
        this.em.persist(new 
        Course(random.nextInt(2048), name, code, level, language, teacher));
    }
    
    @Override
    public void change(int id, String name, String code, String level, String language, String teacher) {
        Course course = this.em.find(Course.class, id);
        course.setName(name);
        course.setCode(code);
        course.setLevel(level);
        course.setLanguage(language);
        course.setTeacher(teacher);
        this.em.merge(course);
    }
    
    @Override
    public void removeCourse(int courseId) {
        System.out.println("Almost success:" + courseId);
        Course course = this.em.find(Course.class, courseId);
        this.em.remove(course);
    }
    
    @Override
    public List<Course> getCourses() {
        Query query = em.createNamedQuery("findAllCourses");
        return query.getResultList();
    }
    
    @Override
    public Course getFromDB(int courseId) {
        return this.em.find(Course.class, courseId);
    }
    
    @Override
    public List<Course> searchCourses(String str1, String str2) {
        Query query = em.createNamedQuery("searchCourses"); 
        query.setParameter("name", str1);
        query.setParameter("code", str2);
        return query.getResultList();
    }
    
    @Override
    public void addStudentToCourse(int courseId, Student student) {
        Course course = this.em.find(Course.class, courseId);
        System.out.println("addStudentToCourse ");
        course.addStudent(student);
        this.em.merge(course);
    }
    
    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        Course course = this.em.find(Course.class, courseId);
        if (course!=null) return course.getStudentCollection();
        return new ArrayList<>();
    }
}
