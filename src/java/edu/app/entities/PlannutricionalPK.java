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
public class PlannutricionalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idplanNutricional")
    private int idplanNutricional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor_id")
    private int instructorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private int clienteId;

    public PlannutricionalPK() {
    }

    public PlannutricionalPK(int idplanNutricional, int instructorId, int clienteId) {
        this.idplanNutricional = idplanNutricional;
        this.instructorId = instructorId;
        this.clienteId = clienteId;
    }

    public int getIdplanNutricional() {
        return idplanNutricional;
    }

    public void setIdplanNutricional(int idplanNutricional) {
        this.idplanNutricional = idplanNutricional;
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
        hash += (int) idplanNutricional;
        hash += (int) instructorId;
        hash += (int) clienteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlannutricionalPK)) {
            return false;
        }
        PlannutricionalPK other = (PlannutricionalPK) object;
        if (this.idplanNutricional != other.idplanNutricional) {
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
        return "edu.app.entities.PlannutricionalPK[ idplanNutricional=" + idplanNutricional + ", instructorId=" + instructorId + ", clienteId=" + clienteId + " ]";
    }

    public Plannutricional setClienteId(Cliente objCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Plannutricional setInstructorId(Instructor objInstructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
