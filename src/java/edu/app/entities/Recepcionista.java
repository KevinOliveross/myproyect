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
@Table(name = "recepcionista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recepcionista.findAll", query = "SELECT r FROM Recepcionista r")
    , @NamedQuery(name = "Recepcionista.findById", query = "SELECT r FROM Recepcionista r WHERE r.id = :id")
    , @NamedQuery(name = "Recepcionista.findByNombre", query = "SELECT r FROM Recepcionista r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Recepcionista.findByApellido", query = "SELECT r FROM Recepcionista r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "Recepcionista.findByEdad", query = "SELECT r FROM Recepcionista r WHERE r.edad = :edad")
    , @NamedQuery(name = "Recepcionista.findByTelefono", query = "SELECT r FROM Recepcionista r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Recepcionista.findByCorreo", query = "SELECT r FROM Recepcionista r WHERE r.correo = :correo")
    , @NamedQuery(name = "Recepcionista.findByEps", query = "SELECT r FROM Recepcionista r WHERE r.eps = :eps")
    , @NamedQuery(name = "Recepcionista.findByFechaNacimiento", query = "SELECT r FROM Recepcionista r WHERE r.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Recepcionista.findByDireccion", query = "SELECT r FROM Recepcionista r WHERE r.direccion = :direccion")
    , @NamedQuery(name = "Recepcionista.findBySalario", query = "SELECT r FROM Recepcionista r WHERE r.salario = :salario")
    , @NamedQuery(name = "Recepcionista.findByContrasenia", query = "SELECT r FROM Recepcionista r WHERE r.contrasenia = :contrasenia")})
public class Recepcionista implements Serializable {

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
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eps")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private int salario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recepcionista", fetch = FetchType.LAZY)
    private Collection<Ordencompra> ordencompraCollection;

    public Recepcionista() {
    }

    public Recepcionista(Integer id) {
        this.id = id;
    }

    public Recepcionista(Integer id, String nombre, String apellido, int edad, String telefono, String correo, String eps, String fechaNacimiento, String direccion, int salario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.eps = eps;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.salario = salario;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection() {
        return ordencompraCollection;
    }

    public void setOrdencompraCollection(Collection<Ordencompra> ordencompraCollection) {
        this.ordencompraCollection = ordencompraCollection;
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
        if (!(object instanceof Recepcionista)) {
            return false;
        }
        Recepcionista other = (Recepcionista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Recepcionista[ id=" + id + " ]";
    }
    
}
