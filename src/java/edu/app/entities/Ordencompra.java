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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "ordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")
    , @NamedQuery(name = "Ordencompra.findByCantidad", query = "SELECT o FROM Ordencompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ordencompra.findByIdOrdenCompra", query = "SELECT o FROM Ordencompra o WHERE o.ordencompraPK.idOrdenCompra = :idOrdenCompra")
    , @NamedQuery(name = "Ordencompra.findByClienteId", query = "SELECT o FROM Ordencompra o WHERE o.ordencompraPK.clienteId = :clienteId")
    , @NamedQuery(name = "Ordencompra.findByRecepcionistaId", query = "SELECT o FROM Ordencompra o WHERE o.ordencompraPK.recepcionistaId = :recepcionistaId")
    , @NamedQuery(name = "Ordencompra.findByProductoIdproducto", query = "SELECT o FROM Ordencompra o WHERE o.ordencompraPK.productoIdproducto = :productoIdproducto")})
public class Ordencompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdencompraPK ordencompraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "recepcionista_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Recepcionista recepcionista;

    public Ordencompra() {
    }

    public Ordencompra(OrdencompraPK ordencompraPK) {
        this.ordencompraPK = ordencompraPK;
    }

    public Ordencompra(OrdencompraPK ordencompraPK, int cantidad) {
        this.ordencompraPK = ordencompraPK;
        this.cantidad = cantidad;
    }

    public Ordencompra(int idOrdenCompra, int clienteId, int recepcionistaId, int productoIdproducto) {
        this.ordencompraPK = new OrdencompraPK(idOrdenCompra, clienteId, recepcionistaId, productoIdproducto);
    }

    public OrdencompraPK getOrdencompraPK() {
        return ordencompraPK;
    }

    public void setOrdencompraPK(OrdencompraPK ordencompraPK) {
        this.ordencompraPK = ordencompraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordencompraPK != null ? ordencompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.ordencompraPK == null && other.ordencompraPK != null) || (this.ordencompraPK != null && !this.ordencompraPK.equals(other.ordencompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.Ordencompra[ ordencompraPK=" + ordencompraPK + " ]";
    }
    
}
