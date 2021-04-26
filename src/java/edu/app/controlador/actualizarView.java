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
@Named(value = "actualizarView")
@SessionScoped
public class actualizarView implements Serializable {

    @EJB
    ClienteFacadeLocal clientefacadelocal;
    /**
     * Creates a new instance of actualizarView
     */
    loginView log = new loginView();
    private String mensaje = "";
    private Cliente objcliente = new Cliente();
    private int idcliente = loginView.getIdCliente();
    private Cliente userFound = new Cliente();

    public actualizarView() {
    }

//Function To Delete Count     
    public void eliminar() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                clientefacadelocal.remove(userFound);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("../index.xhtml");
                System.out.println("Usuario Eliminado");
            } else {
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente " + e);
        }
    }
//Function To Update Data

    public void updateName() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setNombre(objcliente.getNombre());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el nombre es " + e);
        }
    }

    public void updateLastName() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setApellido(objcliente.getApellido());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el apellido es " + e);
        }
    }

    public void updatePassword() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setContrasenia(objcliente.getContrasenia());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el contrasenia es " + e);
        }
    }

    public void updateEmail() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setCorreo(objcliente.getCorreo());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el correo es " + e);
        }
    }

    public void updateAge() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setEdad(objcliente.getEdad());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el edad es " + e);
        }
    }

    public void updateEps() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setEps(objcliente.getEps());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el eps es " + e);
        }
    }

    public void updateFechaNacimiento() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setFechaNacimiento(objcliente.getFechaNacimiento());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el fechanacimiento es " + e);
        }
    }

    public void updateNombreAcudiente() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setNombreAcudiente(objcliente.getNombreAcudiente());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el nombreacudiente es " + e);
        }
    }

    public void updateTelefonoAcudiente() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setTelefonoAcudiente(objcliente.getTelefonoAcudiente());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el telefonoacudiente es " + e);
        }
    }

    public void updateTelefono() {
        try {
            userFound = clientefacadelocal.find(this.idcliente);
            if (userFound != null) {
                userFound.setTelefono(objcliente.getTelefono());
                clientefacadelocal.edit(userFound);
                objcliente = new Cliente();
                mensaje = "sia";
            } else {
                mensaje = "noa";
                System.out.println("Usuario No Encontrado");
            }
        } catch (Exception e) {
            mensaje = "noa";
            System.out.println("El error al actualizar el telefono es " + e);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Cliente getObjcliente() {
        return objcliente;
    }

    public void setObjcliente(Cliente objcli) {
        this.objcliente = objcli;
    }

    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente getUserFound() {
        return userFound;
    }
}
