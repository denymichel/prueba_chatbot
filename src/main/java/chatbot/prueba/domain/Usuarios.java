/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
        , @NamedQuery(name = "Usuarios.findByIdUsuarios", query = "SELECT u FROM Usuarios u WHERE u.idUsuarios = :idUsuarios")
        , @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario")
        , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
        , @NamedQuery(name = "Usuarios.findByEstatus", query = "SELECT u FROM Usuarios u WHERE u.estatus = :estatus")
        , @NamedQuery(name = "Usuarios.findByTxUsuario", query = "SELECT u FROM Usuarios u WHERE u.txUsuario = :txUsuario")
        , @NamedQuery(name = "Usuarios.findByTxHost", query = "SELECT u FROM Usuarios u WHERE u.txHost = :txHost")
        , @NamedQuery(name = "Usuarios.findByTxFecha", query = "SELECT u FROM Usuarios u WHERE u.txFecha = :txFecha")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsuarios")
    private Integer idUsuarios;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "estatus")
    private Integer estatus;
    @Column(name = "tx_usuario")
    private String txUsuario;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_fecha")
    @Temporal(TemporalType.DATE)
    private Date txFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private Collection<Reservas> reservasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private Collection<Imagen> imagenCollection;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
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

    public Date getTxFecha() {
        return txFecha;
    }

    public void setTxFecha(Date txFecha) {
        this.txFecha = txFecha;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection() {
        return imagenCollection;
    }

    public void setImagenCollection(Collection<Imagen> imagenCollection) {
        this.imagenCollection = imagenCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Usuarios[ idUsuarios=" + idUsuarios + " ]";
    }

}
