/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface RegStudentCourse {
    public void addEntry(int studentId, int courseId);

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
