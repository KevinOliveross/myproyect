/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Instructor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevin
 */
@Stateless
public class InstructorFacade extends AbstractFacade<Instructor> implements InstructorFacadeLocal {

    @PersistenceContext(unitName = "GymPeopleProyectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstructorFacade() {
        super(Instructor.class);
    }

    @Override
  public Instructor validarInstructor(String emailInstruc, String passwordInstruc) {
        try {
            Query qt = em.createQuery("SELECT i FROM Instructor i WHERE i.correo = :emailInstruc AND i.contrasenia = :passwordInstruc");
            qt.setParameter("passwordInstruc", passwordInstruc);
            qt.setParameter("emailInstruc", emailInstruc);
            return (Instructor) qt.getSingleResult();
        } catch (Exception e) {
            System.out.println("edu.app.facade.ClienteFacade.validarCliente() " + e.getMessage());
            return null;
        }

    }

}
