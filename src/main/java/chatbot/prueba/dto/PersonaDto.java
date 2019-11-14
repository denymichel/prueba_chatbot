package chatbot.prueba.dto;

import chatbot.prueba.domain.Persona;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PersonaDto {


    private Short idPersona;
    private String nombres;
    private String apellidos;
    private Integer ci;
    private Integer telefono;

//anadiendo mas campos
    private int estatus;
    private String txUser;
    private String txHost;
    private Date txDate;
//fin
    public PersonaDto() {
    }

    public PersonaDto(Persona persona) {
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.ci = persona.getCi();
        this.telefono = persona.getTelefono();

        //anadiendo
        this.estatus = persona.getEstatus();
        this.txUser = persona.getTxUser();
        this.txHost = persona.getTxHost();
        this.txDate = persona.getTxDate();
    }

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



    //anadiendo gettes and setters

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
}
