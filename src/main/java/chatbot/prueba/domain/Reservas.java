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
        , @NamedQuery(name = "Reservas.findByIdReservas", query = "SELECT r FROM Reservas r WHERE r.idReservas = :idReservas")
        , @NamedQuery(name = "Reservas.findByFechaHora", query = "SELECT r FROM Reservas r WHERE r.fechaHora = :fechaHora")
        , @NamedQuery(name = "Reservas.findByTxUsuario", query = "SELECT r FROM Reservas r WHERE r.txUsuario = :txUsuario")
        , @NamedQuery(name = "Reservas.findByTxHost", query = "SELECT r FROM Reservas r WHERE r.txHost = :txHost")
        , @NamedQuery(name = "Reservas.findByTxFecha", query = "SELECT r FROM Reservas r WHERE r.txFecha = :txFecha")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReservas")
    private Integer idReservas;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Column(name = "tx_usuario")
    private String txUsuario;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_fecha")
    @Temporal(TemporalType.DATE)
    private Date txFecha;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;
    @JoinColumn(name = "idEspecialidades", referencedColumnName = "idEspecialidades")
    @ManyToOne(optional = false)
    private Especialidades idEspecialidades;

    public Reservas() {
    }

    public Reservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Especialidades getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Especialidades idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservas != null ? idReservas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReservas == null && other.idReservas != null) || (this.idReservas != null && !this.idReservas.equals(other.idReservas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Reservas[ idReservas=" + idReservas + " ]";
    }

}
