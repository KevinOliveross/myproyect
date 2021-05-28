/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Instructor;
import edu.app.entities.Recepcionista;
import edu.app.facade.ClienteFacadeLocal;
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
@Named(value = "loginView")
@SessionScoped
public class loginView implements Serializable {

    @EJB
    ClienteFacadeLocal clientefacadelocal;
    InstructorFacadeLocal instructorFacadeLocal;
    RecepcionistaFacadeLocal recepcionistaFacadeLocal;

    public loginView() {
    }

    private String mensaje = "";
    private String correoin = "";
    private String clavein = "";
    private static int idcliente;
    private String tipoMensaje = "";
    private String emailInstruc = "";
    private String passwordInstruc = "";
    private String passwordRecep = "";
    private String emailRecep = "";

    private Cliente objcliente = new Cliente();

    private Instructor objInstru = new Instructor();
    private Recepcionista objRecep = new Recepcionista();
    private static int idIns;
    private static int idRecep;

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

    public void loginInstructor() {

        try {

            objInstru = instructorFacadeLocal.validarIns(emailInstruc, passwordInstruc);
            idIns = objInstru.getId();
            if (objInstru.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../instructor/index.xhtml");
                System.out.println("El id es " + idIns);
            } else {
                mensaje = "No,login";
                objInstru = new Instructor();
            }
        } catch (Exception e) {
            System.out.println("El error en validar instructor es :" + e);
            mensaje = "No,login";
        }
    }

    public void loginRecepcionista() {

        try {

            objRecep = recepcionistaFacadeLocal.validarRece(emailRecep, passwordRecep);
            idRecep = objRecep.getId();
            if (objRecep.getCorreo() != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../administracion/index.xhtml");
                System.out.println("El id es " + idRecep);
            } else {
                mensaje = "No,login";
                objRecep = new Recepcionista();
            }
        } catch (Exception e) {
            System.out.println("El error en validar recepcionista es :" + e);
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

    public static int getIdCliente() {
        return idcliente;
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

    public Instructor getObjInstru() {
        return objInstru;
    }

    public void setObjInstru(Instructor objInstru) {
        this.objInstru = objInstru;
    }

    public Recepcionista getObjRecep() {
        return objRecep;
    }

    public void setObjRecep(Recepcionista objRecep) {
        this.objRecep = objRecep;
    }

    public static int getIdIns() {
        return idIns;
    }

    public static int getIdRecep() {
        return idRecep;
    }

}
