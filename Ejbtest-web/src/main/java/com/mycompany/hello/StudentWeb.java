/**
 *
 * @author bjorn
 */
package com.mycompany.hello;

import com.mycompany.ejb.Student;
import com.mycompany.ejb.StudentRegistry;
import java.io.Serializable;
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
    private String eMail;
    private List<Student> students;
    
    @EJB
    private StudentRegistry studentRegistry;

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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
        return studentRegistry.getStudents();
    }

    /*
    public StudentRegistry getStudentRegistry() {
        return studentRegistry;
    }

    public void setStudentRegistry(StudentRegistry studentRegistry) {
        this.studentRegistry = studentRegistry;
    }
    */
    
    public void addStudent() {
        System.out.println("addStudent");
        studentRegistry.addStudent(firstName, lastName, eMail);
    }

}
