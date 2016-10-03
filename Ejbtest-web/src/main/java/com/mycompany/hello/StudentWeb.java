/**
 *
 * @author bjorn
 */
package com.mycompany.hello;

import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@ManagedBean
@Named(value = "sR")
@SessionScoped
public class StudentWeb implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private List<Student> students;
    private List<Student> searchList;
    
    @EJB
    private StudentRegistry studentRegistry;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        System.out.println("veryNew");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("tjosan");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Student> getStudents() {
        System.out.println("getStudents");
        students = studentRegistry.getStudents();
        for(Student s: students) System.out.println(s.getFirstName());
        return students;
    }
    
    public List<Student> getSearchList() {
        System.out.println("getSearchList");
        return searchList;
    }
      
    public StudentRegistry getStudentRegistry() {
        return studentRegistry;
    }

    public void setStudentRegistry(StudentRegistry studentRegistry) {
        this.studentRegistry = studentRegistry;
    }
    
    public void addStudent() {
        System.out.println("addStudent");
        studentRegistry.addStudent(firstName, lastName, email);
    }

     public void doSearch() {
        if (firstName==null) return;
        System.out.println("getSearchList");
        searchList = studentRegistry.searchStudents(firstName);
        for(Student s: searchList) System.out.println(s.getFirstName());
    }
}
