/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

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
            + " or b.lastName = :lastName"
    )
})

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    @Id 
    private int id;
    
    Student() {}
    
    Student(int id, String firstName, String lastName, String email) {
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
