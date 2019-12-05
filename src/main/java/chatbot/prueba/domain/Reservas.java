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
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByIdreservas", query = "SELECT r FROM Reservas r WHERE r.idreservas = :idreservas")
    , @NamedQuery(name = "Reservas.findByFecha", query = "SELECT r FROM Reservas r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reservas.findByHora", query = "SELECT r FROM Reservas r WHERE r.hora = :hora")
    , @NamedQuery(name = "Reservas.findByTxUser", query = "SELECT r FROM Reservas r WHERE r.txUser = :txUser")
    , @NamedQuery(name = "Reservas.findByTxHost", query = "SELECT r FROM Reservas r WHERE r.txHost = :txHost")
    , @NamedQuery(name = "Reservas.findByTxDate", query = "SELECT r FROM Reservas r WHERE r.txDate = :txDate")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservas")
    private Integer idreservas;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
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
    @JoinColumn(name = "especialidades_idespecialidades", referencedColumnName = "idespecialidades")
    @ManyToOne(optional = false)
    private Especialidades especialidadesIdespecialidades;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Reservas() {
    }

    public Reservas(Integer idreservas) {
        this.idreservas = idreservas;
    }

    public Reservas(Integer idreservas, Date fecha, Date hora, String txUser, String txHost, Date txDate) {
        this.idreservas = idreservas;
        this.fecha = fecha;
        this.hora = hora;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIdreservas() {
        return idreservas;
    }

    public void setIdreservas(Integer idreservas) {
        this.idreservas = idreservas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public Especialidades getEspecialidadesIdespecialidades() {
        return especialidadesIdespecialidades;
    }

    public void setEspecialidadesIdespecialidades(Especialidades especialidadesIdespecialidades) {
        this.especialidadesIdespecialidades = especialidadesIdespecialidades;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservas != null ? idreservas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idreservas == null && other.idreservas != null) || (this.idreservas != null && !this.idreservas.equals(other.idreservas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbot.Reservas[ idreservas=" + idreservas + " ]";
    }
    
}
