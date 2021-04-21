/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevin
 */
@Embeddable
public class RutinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idrutina")
    private int idrutina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor_id")
    private int instructorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private int clienteId;

    public RutinaPK() {
    }

    public RutinaPK(int idrutina, int instructorId, int clienteId) {
        this.idrutina = idrutina;
        this.instructorId = instructorId;
        this.clienteId = clienteId;
    }

    public int getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(int idrutina) {
        this.idrutina = idrutina;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idrutina;
        hash += (int) instructorId;
        hash += (int) clienteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinaPK)) {
            return false;
        }
        RutinaPK other = (RutinaPK) object;
        if (this.idrutina != other.idrutina) {
            return false;
        }
        if (this.instructorId != other.instructorId) {
            return false;
        }
        if (this.clienteId != other.clienteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.RutinaPK[ idrutina=" + idrutina + ", instructorId=" + instructorId + ", clienteId=" + clienteId + " ]";
    }
    
}
