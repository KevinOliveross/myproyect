/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    , @NamedQuery(name = "Rutina.findByIdrutina", query = "SELECT r FROM Rutina r WHERE r.idrutina = :idrutina")
    , @NamedQuery(name = "Rutina.findByTemaRutina", query = "SELECT r FROM Rutina r WHERE r.temaRutina = :temaRutina")
    , @NamedQuery(name = "Rutina.findByMusculo", query = "SELECT r FROM Rutina r WHERE r.musculo = :musculo")
    , @NamedQuery(name = "Rutina.findByRepeticiones", query = "SELECT r FROM Rutina r WHERE r.repeticiones = :repeticiones")
    , @NamedQuery(name = "Rutina.findByMaquina", query = "SELECT r FROM Rutina r WHERE r.maquina = :maquina")
    , @NamedQuery(name = "Rutina.findByInstructorId", query = "SELECT r FROM Rutina r WHERE r.instructorId = :instructorId")
    , @NamedQuery(name = "Rutina.findByClienteId", query = "SELECT r FROM Rutina r WHERE r.clienteId = :clienteId")})
public class Rutina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrutina")
    private Integer idrutina;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor_id")
    private int instructorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private int clienteId;

    public Rutina() {
    }

    public Rutina(Integer idrutina) {
        this.idrutina = idrutina;
    }

    public Rutina(Integer idrutina, String temaRutina, String musculo, String repeticiones, String maquina, int instructorId, int clienteId) {
        this.idrutina = idrutina;
        this.temaRutina = temaRutina;
        this.musculo = musculo;
        this.repeticiones = repeticiones;
        this.maquina = maquina;
        this.instructorId = instructorId;
        this.clienteId = clienteId;
    }

    public Integer getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Integer idrutina) {
        this.idrutina = idrutina;
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
        hash += (idrutina != null ? idrutina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutina)) {
            return false;
        }
        Rutina other = (Rutina) object;
        if ((this.idrutina == null && other.idrutina != null) || (this.idrutina != null && !this.idrutina.equals(other.idrutina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Rutina[ idrutina=" + idrutina + " ]";
    }


}
