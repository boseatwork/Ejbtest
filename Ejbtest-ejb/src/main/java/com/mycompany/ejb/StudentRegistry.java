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
public interface StudentRegistry {
    public void addStudent(String str1, String str2, String str3);
    
    public List<Student> getStudents();
    public List<Student> searchStudents(String str);
}
