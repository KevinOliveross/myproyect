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

    public Instructor validarIns(String emailInstruc, String passwordInstruc) {

        try {
            Query consulta = em.createQuery("SELECT c FROM Instructor c WHERE c.contrasenia = :passwordInstruc AND c.correo = :emailInstruc");
            consulta.setParameter("passwordInstruc", passwordInstruc);
            consulta.setParameter("emailInstruc", emailInstruc);
            return (Instructor) consulta.getSingleResult();

        } catch (Exception e) {
            System.out.println("El error en la validacion " + e.getMessage());
            return new Instructor();
        }

    }

}
