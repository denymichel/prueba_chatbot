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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
        , @NamedQuery(name = "Medico.findByIdMedico", query = "SELECT m FROM Medico m WHERE m.idMedico = :idMedico")
        , @NamedQuery(name = "Medico.findByNombres", query = "SELECT m FROM Medico m WHERE m.nombres = :nombres")
        , @NamedQuery(name = "Medico.findByApellidos", query = "SELECT m FROM Medico m WHERE m.apellidos = :apellidos")
        , @NamedQuery(name = "Medico.findByTel\u00e9fono", query = "SELECT m FROM Medico m WHERE m.tel\u00e9fono = :tel\u00e9fono")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_medico")
    private Short idMedico;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "tel\u00e9fono")
    private Integer teléfono;
    @OneToMany(mappedBy = "idMedico")
    private Collection<MedicoEspecialidad> medicoEspecialidadCollection;

    public Medico() {
    }

    public Medico(Short idMedico) {
        this.idMedico = idMedico;
    }

    public Short getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Short idMedico) {
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

    public Integer getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(Integer teléfono) {
        this.teléfono = teléfono;
    }

    @XmlTransient
    public Collection<MedicoEspecialidad> getMedicoEspecialidadCollection() {
        return medicoEspecialidadCollection;
    }

    public void setMedicoEspecialidadCollection(Collection<MedicoEspecialidad> medicoEspecialidadCollection) {
        this.medicoEspecialidadCollection = medicoEspecialidadCollection;
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
        return "domainchatbot.Medico[ idMedico=" + idMedico + " ]";
    }

}
