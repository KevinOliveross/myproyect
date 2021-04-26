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

/**
 *
 * @author juanf
 */
@Named(value = "registroView")
@SessionScoped
public class registroView implements Serializable {

    @EJB
    ClienteFacadeLocal ClienteFacadeLocal;

    /**
     * Creates a new instance of registroView
     */
    public registroView() {
    }
    private Cliente objcliente = new Cliente();

    private String mensaje = "";

    private String correoin = "";
    private String clavein = "";

    public void registrocliente() {
        try {
            ClienteFacadeLocal.create(objcliente);
            objcliente = new Cliente();
            mensaje = "Si";
        } catch (Exception e) {
            mensaje = "No";
            System.out.println("La falla es :" + e);
        }
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

    public String getClavein() {
        return clavein;
    }

    public void setClavein(String clavein) {
        this.clavein = clavein;
    }

    public String getCorreoin() {
        return correoin;
    }

    public void setCorreoin(String correoin) {
        this.correoin = correoin;
    }

}
