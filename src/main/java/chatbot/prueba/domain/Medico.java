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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByIdMedico", query = "SELECT m FROM Medico m WHERE m.idMedico = :idMedico")
    , @NamedQuery(name = "Medico.findByNombres", query = "SELECT m FROM Medico m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Medico.findByApellidos", query = "SELECT m FROM Medico m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Medico.findByTelefono", query = "SELECT m FROM Medico m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "Medico.findByTxUsuario", query = "SELECT m FROM Medico m WHERE m.txUsuario = :txUsuario")
    , @NamedQuery(name = "Medico.findByTxHost", query = "SELECT m FROM Medico m WHERE m.txHost = :txHost")
    , @NamedQuery(name = "Medico.findByTxFecha", query = "SELECT m FROM Medico m WHERE m.txFecha = :txFecha")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMedico")
    private Integer idMedico;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "tx_usuario")
    private String txUsuario;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_fecha")
    @Temporal(TemporalType.DATE)
    private Date txFecha;
    @JoinColumn(name = "idEspecialidades", referencedColumnName = "idEspecialidades")
    @ManyToOne(optional = false)
    private Especialidades idEspecialidades;

    public Medico() {
    }

    public Medico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
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

    public Especialidades getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Especialidades idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cenmed.Medico[ idMedico=" + idMedico + " ]";
    }
    
}
