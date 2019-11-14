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
        import javax.persistence.NamedQueries;
        import javax.persistence.NamedQuery;
        import javax.persistence.Table;
        import javax.xml.bind.annotation.XmlRootElement;


        import javax.persistence.Temporal;
        import javax.persistence.TemporalType;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
        , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
        , @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres")
        , @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")
        , @NamedQuery(name = "Persona.findByCi", query = "SELECT p FROM Persona p WHERE p.ci = :ci")
        , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")

//anadiendo campos extras
        ,@NamedQuery(name = "Persona.findByEstatus", query = "SELECT p FROM Persona p WHERE p.status = :status")
        ,@NamedQuery(name = "Persona.findByTxUser", query = "SELECT p FROM Persona p WHERE p.txUser = :txUser")
        ,@NamedQuery(name = "Persona.findByTxHost", query = "SELECT p FROM Persona p WHERE p.txHost = :txHost")
        ,@NamedQuery(name = "Persona.findByTxDate", query = "SELECT p FROM Persona p WHERE p.txDate = :txDate")})
//fin

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Short idPersona;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "ci")
    private Integer ci;
    @Column(name = "telefono")
    private Integer telefono;

//anadiendo campos extras
    @Basic(optional = false)
    @Column(name = "estatus")
    private int estatus;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private String txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @Basic(optional = false)
    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date txDate;
//fin

    public Persona() {
    }

    public Persona(Short idPersona) {
        this.idPersona = idPersona;
    }

    // anadiend constructor
    public Persona(Short idPersona, String nombres, int estatus, String txUser, String txHost, Date txDate) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.estatus = estatus;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }
    //fin

    public Short getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Short idPersona) {
        this.idPersona = idPersona;
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

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

//anadiendo getters and setters
    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
    //fin getters and setters


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }


    //anadi mas campos en to string
    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci=" + ci +
                ", telefono=" + telefono +
                ", estatus=" + estatus +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
