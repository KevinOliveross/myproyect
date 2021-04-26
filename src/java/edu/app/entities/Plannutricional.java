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
@Table(name = "plannutricional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plannutricional.findAll", query = "SELECT p FROM Plannutricional p")
    , @NamedQuery(name = "Plannutricional.findByIdplanNutricional", query = "SELECT p FROM Plannutricional p WHERE p.idplanNutricional = :idplanNutricional")
    , @NamedQuery(name = "Plannutricional.findByDia", query = "SELECT p FROM Plannutricional p WHERE p.dia = :dia")
    , @NamedQuery(name = "Plannutricional.findByDesayuno", query = "SELECT p FROM Plannutricional p WHERE p.desayuno = :desayuno")
    , @NamedQuery(name = "Plannutricional.findByCena", query = "SELECT p FROM Plannutricional p WHERE p.cena = :cena")
    , @NamedQuery(name = "Plannutricional.findByAlmuerzo", query = "SELECT p FROM Plannutricional p WHERE p.almuerzo = :almuerzo")
    , @NamedQuery(name = "Plannutricional.findByTemaNutricional", query = "SELECT p FROM Plannutricional p WHERE p.temaNutricional = :temaNutricional")
    , @NamedQuery(name = "Plannutricional.findByInstructorId", query = "SELECT p FROM Plannutricional p WHERE p.instructorId = :instructorId")
    , @NamedQuery(name = "Plannutricional.findByClienteId", query = "SELECT p FROM Plannutricional p WHERE p.clienteId = :clienteId")})
public class Plannutricional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanNutricional")
    private Integer idplanNutricional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desayuno")
    private String desayuno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cena")
    private String cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "almuerzo")
    private String almuerzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "temaNutricional")
    private String temaNutricional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor_id")
    private int instructorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private int clienteId;

    public Plannutricional() {
    }

    public Plannutricional(Integer idplanNutricional) {
        this.idplanNutricional = idplanNutricional;
    }

    public Plannutricional(Integer idplanNutricional, String dia, String desayuno, String cena, String almuerzo, String temaNutricional, int instructorId, int clienteId) {
        this.idplanNutricional = idplanNutricional;
        this.dia = dia;
        this.desayuno = desayuno;
        this.cena = cena;
        this.almuerzo = almuerzo;
        this.temaNutricional = temaNutricional;
        this.instructorId = instructorId;
        this.clienteId = clienteId;
    }

    public Integer getIdplanNutricional() {
        return idplanNutricional;
    }

    public void setIdplanNutricional(Integer idplanNutricional) {
        this.idplanNutricional = idplanNutricional;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(String desayuno) {
        this.desayuno = desayuno;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(String almuerzo) {
        this.almuerzo = almuerzo;
    }

    public String getTemaNutricional() {
        return temaNutricional;
    }

    public void setTemaNutricional(String temaNutricional) {
        this.temaNutricional = temaNutricional;
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
        hash += (idplanNutricional != null ? idplanNutricional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plannutricional)) {
            return false;
        }
        Plannutricional other = (Plannutricional) object;
        if ((this.idplanNutricional == null && other.idplanNutricional != null) || (this.idplanNutricional != null && !this.idplanNutricional.equals(other.idplanNutricional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Plannutricional[ idplanNutricional=" + idplanNutricional + " ]";
    }
    
}
