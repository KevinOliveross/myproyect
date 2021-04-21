/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "rutina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutina.findAll", query = "SELECT r FROM Rutina r")
    , @NamedQuery(name = "Rutina.findByIdrutina", query = "SELECT r FROM Rutina r WHERE r.rutinaPK.idrutina = :idrutina")
    , @NamedQuery(name = "Rutina.findByTemaRutina", query = "SELECT r FROM Rutina r WHERE r.temaRutina = :temaRutina")
    , @NamedQuery(name = "Rutina.findByMusculo", query = "SELECT r FROM Rutina r WHERE r.musculo = :musculo")
    , @NamedQuery(name = "Rutina.findByRepeticiones", query = "SELECT r FROM Rutina r WHERE r.repeticiones = :repeticiones")
    , @NamedQuery(name = "Rutina.findByMaquina", query = "SELECT r FROM Rutina r WHERE r.maquina = :maquina")
    , @NamedQuery(name = "Rutina.findByInstructorId", query = "SELECT r FROM Rutina r WHERE r.rutinaPK.instructorId = :instructorId")
    , @NamedQuery(name = "Rutina.findByClienteId", query = "SELECT r FROM Rutina r WHERE r.rutinaPK.clienteId = :clienteId")})
public class Rutina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RutinaPK rutinaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "temaRutina")
    private String temaRutina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "musculo")
    private String musculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "repeticiones")
    private String repeticiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maquina")
    private String maquina;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "instructor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instructor instructor;

    public Rutina() {
    }

    public Rutina(RutinaPK rutinaPK) {
        this.rutinaPK = rutinaPK;
    }

    public Rutina(RutinaPK rutinaPK, String temaRutina, String musculo, String repeticiones, String maquina) {
        this.rutinaPK = rutinaPK;
        this.temaRutina = temaRutina;
        this.musculo = musculo;
        this.repeticiones = repeticiones;
        this.maquina = maquina;
    }

    public Rutina(int idrutina, int instructorId, int clienteId) {
        this.rutinaPK = new RutinaPK(idrutina, instructorId, clienteId);
    }

    public RutinaPK getRutinaPK() {
        return rutinaPK;
    }

    public void setRutinaPK(RutinaPK rutinaPK) {
        this.rutinaPK = rutinaPK;
    }

    public String getTemaRutina() {
        return temaRutina;
    }

    public void setTemaRutina(String temaRutina) {
        this.temaRutina = temaRutina;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaPK != null ? rutinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutina)) {
            return false;
        }
        Rutina other = (Rutina) object;
        if ((this.rutinaPK == null && other.rutinaPK != null) || (this.rutinaPK != null && !this.rutinaPK.equals(other.rutinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Rutina[ rutinaPK=" + rutinaPK + " ]";
    }
    
}
