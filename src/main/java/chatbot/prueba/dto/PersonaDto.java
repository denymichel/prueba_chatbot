package chatbot.prueba.dto;

import chatbot.prueba.domain.Persona;

import javax.persistence.Column;

public class PersonaDto {


    private Short idPersona;
    private String nombres;
    private String apellidos;
    private Integer ci;
    private Integer telefono;

    public PersonaDto() {
    }
    public PersonaDto(Persona persona)
    {
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.ci = persona.getCi();
        this.telefono = persona.getTelefono();
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
}
