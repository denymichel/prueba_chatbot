/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "especialidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidades.findAll", query = "SELECT e FROM Especialidades e")
    , @NamedQuery(name = "Especialidades.findByIdEspecialidades", query = "SELECT e FROM Especialidades e WHERE e.idEspecialidades = :idEspecialidades")
    , @NamedQuery(name = "Especialidades.findByEspecialidad", query = "SELECT e FROM Especialidades e WHERE e.especialidad = :especialidad")})
public class Especialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEspecialidades")
    private Integer idEspecialidades;
    @Column(name = "Especialidad")
    private String especialidad;
    @JoinColumn(name = "idTurnos", referencedColumnName = "idTurnos")
    @ManyToOne(optional = false)
    private Turnos idTurnos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialidades")
    private Collection<Reservas> reservasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialidades")
    private Collection<Medico> medicoCollection;

    public Especialidades() {
    }

    public Especialidades(Integer idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public Integer getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Integer idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Turnos getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Turnos idTurnos) {
        this.idTurnos = idTurnos;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidades != null ? idEspecialidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidades)) {
            return false;
        }
        Especialidades other = (Especialidades) object;
        if ((this.idEspecialidades == null && other.idEspecialidades != null) || (this.idEspecialidades != null && !this.idEspecialidades.equals(other.idEspecialidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cenmed.Especialidades[ idEspecialidades=" + idEspecialidades + " ]";
    }
    
}
