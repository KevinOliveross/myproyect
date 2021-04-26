/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.facade.ClienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanf
 */
@Named(value = "loginView")
@SessionScoped
public class loginView implements Serializable {

    @EJB 
    ClienteFacadeLocal clientefacadelocal;

    public loginView() {
    }

    
    private String mensaje = "";
    private String correoin = "";
    private String clavein = "";
    private static int idcliente;
    
    
    private Cliente objcliente = new Cliente();
    
    
        public void validarcliente() {
        try {
           objcliente = clientefacadelocal.verificacion(correoin, clavein);
           idcliente = objcliente.getId();
            if (objcliente.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../misdatos/index.xhtml");
                System.out.println("El id es " + idcliente);
            } else {
                mensaje = "No,login";
                objcliente = new Cliente();
            }
        } catch (Exception e) {
            System.out.println("El error en validar cliente es :" + e);
            mensaje = "No,login";
        }
    }

    public String getCorreoin() {
        return correoin;
    }

    public void setCorreoin(String correoin) {
        this.correoin = correoin;
    }

    public String getClavein() {
        return clavein;
    }

    public void setClavein(String clavein) {
        this.clavein = clavein;
    }

    public Cliente getObjcliente() {
        return objcliente;
    }

    public void setObjcliente(Cliente objcliente) {
        this.objcliente = objcliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public static int getIdCliente(){
        return idcliente;
    }
        
}
