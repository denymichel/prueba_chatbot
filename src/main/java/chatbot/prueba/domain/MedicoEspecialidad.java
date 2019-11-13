/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

        import java.io.Serializable;
        import javax.persistence.Basic;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.JoinColumn;
        import javax.persistence.ManyToOne;
        import javax.persistence.NamedQueries;
        import javax.persistence.NamedQuery;
        import javax.persistence.Table;
        import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "medico_especialidad")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MedicoEspecialidad.findAll", query = "SELECT m FROM MedicoEspecialidad m")
        , @NamedQuery(name = "MedicoEspecialidad.findByIdMedicoEspecialidad", query = "SELECT m FROM MedicoEspecialidad m WHERE m.idMedicoEspecialidad = :idMedicoEspecialidad")})
public class MedicoEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_medico_especialidad")
    private Short idMedicoEspecialidad;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne
    private Medico idMedico;
    @JoinColumn(name = "id_especialidades", referencedColumnName = "id_especialidades")
    @ManyToOne
    private Especialidades idEspecialidades;

    public MedicoEspecialidad() {
    }

    public MedicoEspecialidad(Short idMedicoEspecialidad) {
        this.idMedicoEspecialidad = idMedicoEspecialidad;
    }

    public Short getIdMedicoEspecialidad() {
        return idMedicoEspecialidad;
    }

    public void setIdMedicoEspecialidad(Short idMedicoEspecialidad) {
        this.idMedicoEspecialidad = idMedicoEspecialidad;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
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
        hash += (idMedicoEspecialidad != null ? idMedicoEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoEspecialidad)) {
            return false;
        }
        MedicoEspecialidad other = (MedicoEspecialidad) object;
        if ((this.idMedicoEspecialidad == null && other.idMedicoEspecialidad != null) || (this.idMedicoEspecialidad != null && !this.idMedicoEspecialidad.equals(other.idMedicoEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainchatbot.MedicoEspecialidad[ idMedicoEspecialidad=" + idMedicoEspecialidad + " ]";
    }

}
