/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")
    , @NamedQuery(name = "Archivo.findByIdarchivo", query = "SELECT a FROM Archivo a WHERE a.idarchivo = :idarchivo")
    , @NamedQuery(name = "Archivo.findByImagen", query = "SELECT a FROM Archivo a WHERE a.imagen = :imagen")
    , @NamedQuery(name = "Archivo.findByTxUser", query = "SELECT a FROM Archivo a WHERE a.txUser = :txUser")
    , @NamedQuery(name = "Archivo.findByTxHost", query = "SELECT a FROM Archivo a WHERE a.txHost = :txHost")
    , @NamedQuery(name = "Archivo.findByTxDate", query = "SELECT a FROM Archivo a WHERE a.txDate = :txDate")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarchivo")
    private Integer idarchivo;
    @Basic(optional = false)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private String txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @Basic(optional = false)
    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date txDate;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Archivo() {
    }

    public Archivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public Archivo(Integer idarchivo, String imagen, String txUser, String txHost, Date txDate) {
        this.idarchivo = idarchivo;
        this.imagen = imagen;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIdarchivo() {
        return idarchivo;
    }

    public void setIdarchivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarchivo != null ? idarchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idarchivo == null && other.idarchivo != null) || (this.idarchivo != null && !this.idarchivo.equals(other.idarchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbotuno.Archivo[ idarchivo=" + idarchivo + " ]";
    }
    
}
