/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id")
    , @NamedQuery(name = "Instructor.findByNombre", query = "SELECT i FROM Instructor i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instructor.findByApellido", query = "SELECT i FROM Instructor i WHERE i.apellido = :apellido")
    , @NamedQuery(name = "Instructor.findByEdad", query = "SELECT i FROM Instructor i WHERE i.edad = :edad")
    , @NamedQuery(name = "Instructor.findByFechaNacimiento", query = "SELECT i FROM Instructor i WHERE i.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Instructor.findByTelefono", query = "SELECT i FROM Instructor i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "Instructor.findByCorreo", query = "SELECT i FROM Instructor i WHERE i.correo = :correo")
    , @NamedQuery(name = "Instructor.findByEps", query = "SELECT i FROM Instructor i WHERE i.eps = :eps")
    , @NamedQuery(name = "Instructor.findBySalario", query = "SELECT i FROM Instructor i WHERE i.salario = :salario")
    , @NamedQuery(name = "Instructor.findByDireccion", query = "SELECT i FROM Instructor i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Instructor.findByContrasenia", query = "SELECT i FROM Instructor i WHERE i.contrasenia = :contrasenia")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eps")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "salario")
    private String salario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor", fetch = FetchType.LAZY)
    private Collection<Rutina> rutinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor", fetch = FetchType.LAZY)
    private Collection<Plannutricional> plannutricionalCollection;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Instructor(Integer id, String nombre, String apellido, int edad, String fechaNacimiento, String telefono, String correo, String eps, String salario, String direccion, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.eps = eps;
        this.salario = salario;
        this.direccion = direccion;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public Collection<Rutina> getRutinaCollection() {
        return rutinaCollection;
    }

    public void setRutinaCollection(Collection<Rutina> rutinaCollection) {
        this.rutinaCollection = rutinaCollection;
    }

    @XmlTransient
    public Collection<Plannutricional> getPlannutricionalCollection() {
        return plannutricionalCollection;
    }

    public void setPlannutricionalCollection(Collection<Plannutricional> plannutricionalCollection) {
        this.plannutricionalCollection = plannutricionalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Instructor[ id=" + id + " ]";
    }
    
}
