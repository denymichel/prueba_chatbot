
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i")
        , @NamedQuery(name = "Imagen.findByIdimagen", query = "SELECT i FROM Imagen i WHERE i.idimagen = :idimagen")
        , @NamedQuery(name = "Imagen.findByTxUsuario", query = "SELECT i FROM Imagen i WHERE i.txUsuario = :txUsuario")
        , @NamedQuery(name = "Imagen.findByTxHost", query = "SELECT i FROM Imagen i WHERE i.txHost = :txHost")
        , @NamedQuery(name = "Imagen.findByTxFecha", query = "SELECT i FROM Imagen i WHERE i.txFecha = :txFecha")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idimagen")
    private Integer idimagen;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "tx_usuario")
    private String txUsuario;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_fecha")
    private String txFecha;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;

    public Imagen() {
    }

    public Imagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public Integer getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getTxUsuario() {
        return txUsuario;
    }

    public void setTxUsuario(String txUsuario) {
        this.txUsuario = txUsuario;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxFecha() {
        return txFecha;
    }

    public void setTxFecha(String txFecha) {
        this.txFecha = txFecha;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimagen != null ? idimagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.idimagen == null && other.idimagen != null) || (this.idimagen != null && !this.idimagen.equals(other.idimagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Imagen[ idimagen=" + idimagen + " ]";
    }

}
