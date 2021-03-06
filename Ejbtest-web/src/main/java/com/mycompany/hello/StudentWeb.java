/**
 *
 * @author bjorn
 */
package com.mycompany.hello;

import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentRegistry;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "sR")
@SessionScoped
public class StudentWeb implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private int studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Student> getStudents() {
        System.out.println("setStudents");
        students = studentRegistry.getStudents();
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
        firstName = "";
        lastName = "";
        email = "";
    }
    
    public void prepareChange() {
        System.out.println("prepareChange");
        Student student = studentRegistry.getFromDB(studentId);
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
    
    public void change() {
        System.out.println("change");
        studentRegistry.change(studentId, firstName, lastName, email);
        firstName = "";
        lastName = "";
        email = "";
    }
    
    public void removeStudent() {
        System.out.println("removeStudent");
        studentRegistry.removeStudent(studentId);
        firstName = "";
        lastName = "";
        email = "";
    }

     public void doSearch() {
        if (firstName==null) return;
        System.out.println("doSearch");
        searchList = studentRegistry.searchStudents(firstName, lastName);
     }
}
