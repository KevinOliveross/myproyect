/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Instructor;
import edu.app.entities.Recepcionista;
import edu.app.facade.InstructorFacadeLocal;
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
@Named(value = "loginViewInstruc")
@SessionScoped
public class loginViewInstru implements Serializable {

    @EJB
    InstructorFacadeLocal instructorFacadeLocal;

    public loginViewInstru() {
    }

    private String mensaje = "";
    private String tipoMensaje = "";
    private String emailInstruc = "";
    private String passwordInstruc = "";

    private Instructor objInstru = new Instructor();

    public void validarInstruct() {
        try {
            objInstru = instructorFacadeLocal.validarInstructor(emailInstruc, passwordInstruc);
            if (objInstru.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../instructor/index.xhtml");
            } else {
                mensaje = "No,login";
                objInstru = new Instructor();
            }
        } catch (Exception e) {
            mensaje = "No,login";
            System.out.println("El  objeto instructor es -> " + objInstru.getCorreo());
            System.out.println("El error es por -> " + e);
        }

    }
 
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getEmailInstruc() {
        return emailInstruc;
    }

    public void setEmailInstruc(String emailInstruc) {
        this.emailInstruc = emailInstruc;
    }

    public String getPasswordInstruc() {
        return passwordInstruc;
    }

    public void setPasswordInstruc(String passwordInstruc) {
        this.passwordInstruc = passwordInstruc;
    }
    
    public Instructor getObjInstru() {
        return objInstru;
    }

    public void setObjInstru(Instructor objInstru) {
        this.objInstru = objInstru;
    }

}
