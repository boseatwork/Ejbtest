/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bjorn
 */
@Local
public interface CourseRegistry {
    public void addCourse(String str1, String str2, String str3, String str4, String str5);
    public void change(int id, String str1, String str2, String str3, String str4, String str5);
    public void removeCourse(int courseId);
    
    public Course2 getFromDB(int courseId);
    public List<Course2> getCourses();
    public List<Course2> searchCourses(String str1, String str2);
}
