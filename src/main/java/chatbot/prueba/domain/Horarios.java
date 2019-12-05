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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findByIdhorarios", query = "SELECT h FROM Horarios h WHERE h.idhorarios = :idhorarios")
    , @NamedQuery(name = "Horarios.findByHoraInicio", query = "SELECT h FROM Horarios h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "Horarios.findByHoraFin", query = "SELECT h FROM Horarios h WHERE h.horaFin = :horaFin")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorarios")
    private Integer idhorarios;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    private String horaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horariosIdhorarios")
    private Collection<Especialidades> especialidadesCollection;

    public Horarios() {
    }

    public Horarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public Horarios(Integer idhorarios, String horaInicio, String horaFin) {
        this.idhorarios = idhorarios;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdhorarios() {
        return idhorarios;
    }

    public void setIdhorarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @XmlTransient
    public Collection<Especialidades> getEspecialidadesCollection() {
        return especialidadesCollection;
    }

    public void setEspecialidadesCollection(Collection<Especialidades> especialidadesCollection) {
        this.especialidadesCollection = especialidadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorarios != null ? idhorarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idhorarios == null && other.idhorarios != null) || (this.idhorarios != null && !this.idhorarios.equals(other.idhorarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbot.Horarios[ idhorarios=" + idhorarios + " ]";
    }
    
}
