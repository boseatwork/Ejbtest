/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author bjorn
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name="findAllStudents",
            query="select b from Student b"
    ),
    @NamedQuery(
            name="searchStudents",
            query="select b from Student b where b.firstName = :firstName"
                    + " or b.lastName = :lastName"
    ),
    @NamedQuery(
            name="exactMatch",
            query="select b from Student b where b.firstName = :firstName" 
            + " and b.lastName = :lastName"
    )
})

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    /*@ManyToMany(targetEntity=Course2.class, mappedBy="studentCollection")
    private List<Course2> courseCollection; */
    @Id 
    private int id;
    
    public Student() {}
    
    public Student(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
    
    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email; 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
