/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.prueba.domain;

        import java.io.Serializable;
        import java.util.Collection;
        import java.util.Date;
        import javax.persistence.Basic;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.NamedQueries;
        import javax.persistence.NamedQuery;
        import javax.persistence.OneToMany;
        import javax.persistence.Table;
        import javax.persistence.Temporal;
        import javax.persistence.TemporalType;
        import javax.xml.bind.annotation.XmlRootElement;
        import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t")
        , @NamedQuery(name = "Turnos.findByIdTurnos", query = "SELECT t FROM Turnos t WHERE t.idTurnos = :idTurnos")
        , @NamedQuery(name = "Turnos.findByTurno", query = "SELECT t FROM Turnos t WHERE t.turno = :turno")
        , @NamedQuery(name = "Turnos.findByFecha", query = "SELECT t FROM Turnos t WHERE t.fecha = :fecha")
        , @NamedQuery(name = "Turnos.findByHora", query = "SELECT t FROM Turnos t WHERE t.hora = :hora")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_turnos")
    private Short idTurnos;
    @Column(name = "turno")
    private String turno;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @OneToMany(mappedBy = "idTurnos")
    private Collection<Especialidades> especialidadesCollection;

    public Turnos() {
    }

    public Turnos(Short idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Short getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Short idTurnos) {
        this.idTurnos = idTurnos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
        hash += (idTurnos != null ? idTurnos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idTurnos == null && other.idTurnos != null) || (this.idTurnos != null && !this.idTurnos.equals(other.idTurnos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainchatbot.Turnos[ idTurnos=" + idTurnos + " ]";
    }

}
