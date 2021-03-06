/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Instructor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kevin
 */
@Local
public interface InstructorFacadeLocal {

    void create(Instructor instructor);

    void edit(Instructor instructor);

    void remove(Instructor instructor);

    Instructor find(Object id);

    List<Instructor> findAll();

    List<Instructor> findRange(int[] range);

    int count();

    public Instructor validarInstructor(String emailInstruc, String passwordInstruc);
    
}
