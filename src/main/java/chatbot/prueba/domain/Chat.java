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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findByIdchat", query = "SELECT c FROM Chat c WHERE c.idchat = :idchat")
    , @NamedQuery(name = "Chat.findByInMessage", query = "SELECT c FROM Chat c WHERE c.inMessage = :inMessage")
    , @NamedQuery(name = "Chat.findByOutMessage", query = "SELECT c FROM Chat c WHERE c.outMessage = :outMessage")
    , @NamedQuery(name = "Chat.findByMsgFecha", query = "SELECT c FROM Chat c WHERE c.msgFecha = :msgFecha")
    , @NamedQuery(name = "Chat.findByTxUser", query = "SELECT c FROM Chat c WHERE c.txUser = :txUser")
    , @NamedQuery(name = "Chat.findByTxHost", query = "SELECT c FROM Chat c WHERE c.txHost = :txHost")
    , @NamedQuery(name = "Chat.findByTxDate", query = "SELECT c FROM Chat c WHERE c.txDate = :txDate")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchat")
    private Integer idchat;
    @Basic(optional = false)
    @Column(name = "in_message")
    private String inMessage;
    @Basic(optional = false)
    @Column(name = "out_message")
    private String outMessage;
    @Basic(optional = false)
    @Column(name = "msg_fecha")
    @Temporal(TemporalType.DATE)
    private Date msgFecha;
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
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Chat() {
    }

    public Chat(Integer idchat) {
        this.idchat = idchat;
    }

    public Chat(Integer idchat, String inMessage, String outMessage, Date msgFecha, String txUser, String txHost, Date txDate) {
        this.idchat = idchat;
        this.inMessage = inMessage;
        this.outMessage = outMessage;
        this.msgFecha = msgFecha;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIdchat() {
        return idchat;
    }

    public void setIdchat(Integer idchat) {
        this.idchat = idchat;
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

    public Date getMsgFecha() {
        return msgFecha;
    }

    public void setMsgFecha(Date msgFecha) {
        this.msgFecha = msgFecha;
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

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchat != null ? idchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.idchat == null && other.idchat != null) || (this.idchat != null && !this.idchat.equals(other.idchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chatbot.Chat[ idchat=" + idchat + " ]";
    }
    
}
