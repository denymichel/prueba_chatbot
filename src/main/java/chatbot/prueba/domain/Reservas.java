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
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
        , @NamedQuery(name = "Reservas.findByIdReservas", query = "SELECT r FROM Reservas r WHERE r.idReservas = :idReservas")
        , @NamedQuery(name = "Reservas.findByFecha", query = "SELECT r FROM Reservas r WHERE r.fecha = :fecha")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reservas")
    private Short idReservas;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public Reservas() {
    }

    public Reservas(Short idReservas) {
        this.idReservas = idReservas;
    }

    public Short getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Short idReservas) {
        this.idReservas = idReservas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservas != null ? idReservas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReservas == null && other.idReservas != null) || (this.idReservas != null && !this.idReservas.equals(other.idReservas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainchatbot.Reservas[ idReservas=" + idReservas + " ]";
    }

}
