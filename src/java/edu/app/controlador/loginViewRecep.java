/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Recepcionista;
import edu.app.facade.RecepcionistaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanf
 */
@Named(value = "loginViewRecep")
@SessionScoped
public class loginViewRecep implements Serializable {
    
    private String mensaje = "";
    private String passwordRecep = "";
    private String emailRecep = "";
    
    @EJB
    RecepcionistaFacadeLocal recepcionistaFacadeLocal;

    public loginViewRecep() {
    }
    
    private Recepcionista objRecep = new Recepcionista();
 

    public void loginRecepcionista() {
        try {
            objRecep = recepcionistaFacadeLocal.validarRece(emailRecep, passwordRecep);
            if (objRecep.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../administracion/index.xhtml");
            } else {
                mensaje = "No,login";
                objRecep = new Recepcionista();
            }
        } catch (Exception e) {
            System.out.println("El error en validar recepcionista es :" + e);
            mensaje = "No,login";
        }
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPasswordRecep() {
        return passwordRecep;
    }

    public void setPasswordRecep(String passwordRecep) {
        this.passwordRecep = passwordRecep;
    }

    public String getEmailRecep() {
        return emailRecep;
    }

    public void setEmailRecep(String emailRecep) {
        this.emailRecep = emailRecep;
    }

    public Recepcionista getObjRecep() {
        return objRecep;
    }

    public void setObjRecep(Recepcionista objRecep) {
        this.objRecep = objRecep;
    }

}
