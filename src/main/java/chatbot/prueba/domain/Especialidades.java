
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

        import java.io.Serializable;
        import java.util.Collection;
        import javax.persistence.Basic;
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
    @Column(name = "id_especialidades")
    private Short idEspecialidades;
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(mappedBy = "idEspecialidades")
    private Collection<MedicoEspecialidad> medicoEspecialidadCollection;
    @JoinColumn(name = "id_turnos", referencedColumnName = "id_turnos")
    @ManyToOne
    private Turnos idTurnos;

    public Especialidades() {
    }

    public Especialidades(Short idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public Short getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Short idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @XmlTransient
    public Collection<MedicoEspecialidad> getMedicoEspecialidadCollection() {
        return medicoEspecialidadCollection;
    }

    public void setMedicoEspecialidadCollection(Collection<MedicoEspecialidad> medicoEspecialidadCollection) {
        this.medicoEspecialidadCollection = medicoEspecialidadCollection;
    }

    public Turnos getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Turnos idTurnos) {
        this.idTurnos = idTurnos;
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
        return "domainchatbot.Especialidades[ idEspecialidades=" + idEspecialidades + " ]";
    }

}

