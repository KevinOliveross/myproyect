/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.facade.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevin
 */
@Named(value = "registrousu")
@ViewScoped
public class registrousu implements Serializable {

    @EJB
    ClienteFacadeLocal clienteFacadeLocal;

    private Cliente objUser = new Cliente();

    private ArrayList<Cliente> tablaUser = new ArrayList<>();

    private String tipoMensajeReg = "";
    private String tipoMensajeRegLo = "";
    private String emailIn = "";
    private String passwordIn = "";

    /**
     * Creates a new instance of registrousu
     */
    public registrousu() {
    }

    @PostConstruct
    public void init() {

        tablaUser.addAll(clienteFacadeLocal.findAll());

    }

    public void registrarUser() {
        try {
            clienteFacadeLocal.create(objUser);
            tipoMensajeReg = "usuarioCreado";
        } catch (Exception e) {
            tipoMensajeReg = "usuarioNoCreado";
            System.out.println("Error!");
        }
    }

    public void eliminarUser(Cliente eliminarUsuario) {
        try {
            clienteFacadeLocal.remove(eliminarUsuario);
            tablaUser.remove(eliminarUsuario);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void actualizar() {
        try {
            clienteFacadeLocal.edit(objUser);
            objUser = new Cliente();
            tipoMensajeReg = "actualizadoU";
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../administracion/cliente/index.xhtml");

        } catch (Exception e) {
            tipoMensajeReg = "noActualizadoU";
            System.out.println("edu.app.controlador.ListaRutinasView.actualizar()" + e.getMessage());
        }
    }

    public void validarCliente() {

        try {
            Cliente clientLog = clienteFacadeLocal.validarCliente(emailIn, passwordIn);
            if (clientLog.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../administracion/cliente/index.xhtml");

            } else {
                tipoMensajeRegLo = "no_L";
            }

        } catch (Exception e) {
            tipoMensajeRegLo = "no_L";

        }

    }

    public Cliente getObjUser() {
        return objUser;
    }

    public void setObjUser(Cliente objUser) {
        this.objUser = objUser;
    }

    public ArrayList<Cliente> getTablaUser() {
        return tablaUser;
    }

    public void setTablaUser(ArrayList<Cliente> tablaUser) {
        this.tablaUser = tablaUser;
    }

    public String getTipoMensajeReg() {
        return tipoMensajeReg;
    }

    public void setTipoMensajeReg(String tipoMensajeReg) {
        this.tipoMensajeReg = tipoMensajeReg;
    }

    public String getTipoMensajeRegLo() {
        return tipoMensajeRegLo;
    }

    public void setTipoMensajeRegLo(String tipoMensajeRegLo) {
        this.tipoMensajeRegLo = tipoMensajeRegLo;
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

}
