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
public class OrdencompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idOrdenCompra")
    private int idOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private int clienteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recepcionista_id")
    private int recepcionistaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_idproducto")
    private int productoIdproducto;

    public OrdencompraPK() {
    }

    public OrdencompraPK(int idOrdenCompra, int clienteId, int recepcionistaId, int productoIdproducto) {
        this.idOrdenCompra = idOrdenCompra;
        this.clienteId = clienteId;
        this.recepcionistaId = recepcionistaId;
        this.productoIdproducto = productoIdproducto;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getRecepcionistaId() {
        return recepcionistaId;
    }

    public void setRecepcionistaId(int recepcionistaId) {
        this.recepcionistaId = recepcionistaId;
    }

    public int getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(int productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenCompra;
        hash += (int) clienteId;
        hash += (int) recepcionistaId;
        hash += (int) productoIdproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdencompraPK)) {
            return false;
        }
        OrdencompraPK other = (OrdencompraPK) object;
        if (this.idOrdenCompra != other.idOrdenCompra) {
            return false;
        }
        if (this.clienteId != other.clienteId) {
            return false;
        }
        if (this.recepcionistaId != other.recepcionistaId) {
            return false;
        }
        if (this.productoIdproducto != other.productoIdproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entities.OrdencompraPK[ idOrdenCompra=" + idOrdenCompra + ", clienteId=" + clienteId + ", recepcionistaId=" + recepcionistaId + ", productoIdproducto=" + productoIdproducto + " ]";
    }
    
}
