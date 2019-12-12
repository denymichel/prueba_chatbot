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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Display
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
        , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
        , @NamedQuery(name = "Usuario.findByBotUserId", query = "SELECT u FROM Usuario u WHERE u.botUserId = :botUserId")
        , @NamedQuery(name = "Usuario.findByChatUserId", query = "SELECT u FROM Usuario u WHERE u.chatUserId = :chatUserId")
        , @NamedQuery(name = "Usuario.findByConversacionId", query = "SELECT u FROM Usuario u WHERE u.conversacionId = :conversacionId")
        , @NamedQuery(name = "Usuario.findBySubConversacionId", query = "SELECT u FROM Usuario u WHERE u.subConversacionId = :subConversacionId")
        , @NamedQuery(name = "Usuario.findByInMessage", query = "SELECT u FROM Usuario u WHERE u.inMessage = :inMessage")
        , @NamedQuery(name = "Usuario.findByOutMessage", query = "SELECT u FROM Usuario u WHERE u.outMessage = :outMessage")
        , @NamedQuery(name = "Usuario.findByTxUser", query = "SELECT u FROM Usuario u WHERE u.txUser = :txUser")
        , @NamedQuery(name = "Usuario.findByTxHost", query = "SELECT u FROM Usuario u WHERE u.txHost = :txHost")
        , @NamedQuery(name = "Usuario.findByTxDate", query = "SELECT u FROM Usuario u WHERE u.txDate = :txDate")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "bot_user_id")
    private String botUserId;
    @Column(name = "chat_user_id")
    private String chatUserId;
    @Column(name = "conversacion_id")
    private Integer conversacionId;
    @Column(name = "sub_conversacion_id")
    private Integer subConversacionId;
    @Column(name = "in_message")
    private String inMessage;
    @Column(name = "out_message")
    private String outMessage;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<Archivo> archivoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<Chat> chatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<Reservas> reservasCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String botUserId, String txUser, String txHost, Date txDate) {
        this.idusuario = idusuario;
        this.botUserId = botUserId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getBotUserId() {
        return botUserId;
    }

    public void setBotUserId(String botUserId) {
        this.botUserId = botUserId;
    }

    public String getChatUserId() {
        return chatUserId;
    }

    public void setChatUserId(String chatUserId) {
        this.chatUserId = chatUserId;
    }

    public Integer getConversacionId() {
        return conversacionId;
    }

    public void setConversacionId(Integer conversacionId) {
        this.conversacionId = conversacionId;
    }

    public Integer getSubConversacionId() {
        return subConversacionId;
    }

    public void setSubConversacionId(Integer subConversacionId) {
        this.subConversacionId = subConversacionId;
    }

    public String getInMessage() {
        return inMessage;
    }

    public void setInMessage(String inMessage) {
        this.inMessage = inMessage;
    }

    public String getOutMessage() {
        return outMessage;
    }

    public void setOutMessage(String outMessage) {
        this.outMessage = outMessage;
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

    @XmlTransient
    public Collection<Archivo> getArchivoCollection() {
        return archivoCollection;
    }

    public void setArchivoCollection(Collection<Archivo> archivoCollection) {
        this.archivoCollection = archivoCollection;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbotdos.Usuario[ idusuario=" + idusuario + " ]";
    }

}
