/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevin
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "GymPeopleProyectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente verificacion(String correoin, String clavein) {
        try {

            Query consulta = em.createQuery("SELECT c FROM Cliente c WHERE c.contrasenia = :clavein AND c.correo = :correoin");
            consulta.setParameter("clavein", clavein);
            consulta.setParameter("correoin", correoin);
            return (Cliente) consulta.getSingleResult();

        } catch (Exception e) {
            System.out.println("El error en la validacion " + e.getMessage());
            return new Cliente();
        }
    }  
    
    @Override
    public Cliente getCorreo(String correoin){
        try{
            Query peticion = em.createQuery("SELECT c FROM Cliente c WHERE c.correo = :correoin");
            peticion.setParameter("correoin",correoin);
            return (Cliente) peticion.getSingleResult();
        }catch(Exception e){
            System.out.println("El error el Usuario por correo es : " + e.getMessage());
            return new Cliente();
        }
    }
    
          
    @Override
          public Cliente validarCliente( String emailIn, String passwordIn){
        
        try{
            
            Query qt = em.createQuery("SELECT c FROM Cliente c WHERE c.contrasenia = :passwordIn AND c.correo = :emailIn");
            qt.setParameter("passwordIn", passwordIn);
            qt.setParameter("emailIn", emailIn);
            return (Cliente) qt.getSingleResult();
        
        } catch (Exception e){
            System.out.println("edu.app.facade.ClienteFacade.validarCliente() " +e.getMessage());
            return new Cliente();
        }
    
    }
    
}
