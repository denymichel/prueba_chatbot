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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "Especialidades.findByIdespecialidades", query = "SELECT e FROM Especialidades e WHERE e.idespecialidades = :idespecialidades")
    , @NamedQuery(name = "Especialidades.findByEspecialidad", query = "SELECT e FROM Especialidades e WHERE e.especialidad = :especialidad")})
public class Especialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecialidades")
    private Integer idespecialidades;
    @Basic(optional = false)
    @Column(name = "especialidad")
    private String especialidad;
    @JoinColumn(name = "horarios_idhorarios", referencedColumnName = "idhorarios")
    @ManyToOne(optional = false)
    private Horarios horariosIdhorarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadesIdespecialidades")
    private Collection<Reservas> reservasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadesIdespecialidades")
    private Collection<Medico> medicoCollection;

    public Especialidades() {
    }

    public Especialidades(Integer idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public Especialidades(Integer idespecialidades, String especialidad) {
        this.idespecialidades = idespecialidades;
        this.especialidad = especialidad;
    }

    public Integer getIdespecialidades() {
        return idespecialidades;
    }

    public void setIdespecialidades(Integer idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Horarios getHorariosIdhorarios() {
        return horariosIdhorarios;
    }

    public void setHorariosIdhorarios(Horarios horariosIdhorarios) {
        this.horariosIdhorarios = horariosIdhorarios;
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
        hash += (idespecialidades != null ? idespecialidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidades)) {
            return false;
        }
        Especialidades other = (Especialidades) object;
        if ((this.idespecialidades == null && other.idespecialidades != null) || (this.idespecialidades != null && !this.idespecialidades.equals(other.idespecialidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbot.Especialidades[ idespecialidades=" + idespecialidades + " ]";
    }
    
}
