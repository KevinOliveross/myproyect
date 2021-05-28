/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Instructor;


import edu.app.facade.ClienteFacadeLocal;
import edu.app.facade.InstructorFacadeLocal;
import edu.app.facade.RecepcionistaFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevin
 */
@Named(value = "registroClient")
@ViewScoped
public class RegistroClient implements Serializable {

    /**
     * Creates a new instance of RegistroClient
     */
    @EJB
    ClienteFacadeLocal clienteFacadeLocal;
    @EJB
    InstructorFacadeLocal instructorFacadeLocal;
    @EJB
    RecepcionistaFacadeLocal recepcionistaFacadeLocal;

    private String tipoMensaje = "";
    private String emailIn = "";
    private String emailInstruc = "";
    private String passwordInstruc = "";
    
      private String emailRecep = "";
      private String passwordRecep = "";

    private String passwordIn = "";

    private Cliente objCliente = new Cliente();

    public RegistroClient() {
    }

    public void registrarClient() {
        try {
            clienteFacadeLocal.create(objCliente);
            tipoMensaje = "registrado";
            objCliente = new Cliente();

        } catch (Exception e) {
            tipoMensaje = "no_Registrado";
            System.out.println("edu.app.controlador.RegistroView.registrarUsuario()" + e.getMessage());

        }

    }




    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getEmailIn() {
        return emailIn;
    }

    public void setEmailIn(String emailIn) {
        this.emailIn = emailIn;
    }

    public String getPasswordIn() {
        return passwordIn;
    }

    public void setPasswordIn(String passwordIn) {
        this.passwordIn = passwordIn;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
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

    public String getEmailRecep() {
        return emailRecep;
    }

    public void setEmailRecep(String emailRecep) {
        this.emailRecep = emailRecep;
    }

    public String getPasswordRecep() {
        return passwordRecep;
    }

    public void setPasswordRecep(String passwordRecep) {
        this.passwordRecep = passwordRecep;
    }

}
