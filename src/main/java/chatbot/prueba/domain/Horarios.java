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
    , @NamedQuery(name = "Horarios.findByTurno", query = "SELECT h FROM Horarios h WHERE h.turno = :turno")
    , @NamedQuery(name = "Horarios.findByHora", query = "SELECT h FROM Horarios h WHERE h.hora = :hora")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorarios")
    private Integer idhorarios;
    @Basic(optional = false)
    @Column(name = "turno")
    private String turno;
    @Basic(optional = false)
    @Column(name = "hora")
    private String hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhorarios")
    private Collection<EspecialidadHorario> especialidadHorarioCollection;

    public Horarios() {
    }

    public Horarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public Horarios(Integer idhorarios, String turno, String hora) {
        this.idhorarios = idhorarios;
        this.turno = turno;
        this.hora = hora;
    }

    public Integer getIdhorarios() {
        return idhorarios;
    }

    public void setIdhorarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlTransient
    public Collection<EspecialidadHorario> getEspecialidadHorarioCollection() {
        return especialidadHorarioCollection;
    }

    public void setEspecialidadHorarioCollection(Collection<EspecialidadHorario> especialidadHorarioCollection) {
        this.especialidadHorarioCollection = especialidadHorarioCollection;
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
        return "chatbotuno.Horarios[ idhorarios=" + idhorarios + " ]";
    }
    
}
