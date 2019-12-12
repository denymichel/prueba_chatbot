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
@Table(name = "especialidad_horario")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "EspecialidadHorario.findAll", query = "SELECT e FROM EspecialidadHorario e")
        , @NamedQuery(name = "EspecialidadHorario.findByIdEH", query = "SELECT e FROM EspecialidadHorario e WHERE e.idEH = :idEH")})
public class EspecialidadHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_e_h")
    private Integer idEH;
    @JoinColumn(name = "idespecialidades", referencedColumnName = "idespecialidades")
    @ManyToOne(optional = false)
    private Especialidades idespecialidades;
    @JoinColumn(name = "idhorarios", referencedColumnName = "idhorarios")
    @ManyToOne(optional = false)
    private Horarios idhorarios;

    public EspecialidadHorario() {
    }

    public EspecialidadHorario(Integer idEH) {
        this.idEH = idEH;
    }

    public Integer getIdEH() {
        return idEH;
    }

    public void setIdEH(Integer idEH) {
        this.idEH = idEH;
    }

    public Especialidades getIdespecialidades() {
        return idespecialidades;
    }

    public void setIdespecialidades(Especialidades idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public Horarios getIdhorarios() {
        return idhorarios;
    }

    public void setIdhorarios(Horarios idhorarios) {
        this.idhorarios = idhorarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEH != null ? idEH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadHorario)) {
            return false;
        }
        EspecialidadHorario other = (EspecialidadHorario) object;
        if ((this.idEH == null && other.idEH != null) || (this.idEH != null && !this.idEH.equals(other.idEH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbotuno.EspecialidadHorario[ idEH=" + idEH + " ]";
    }

}
