package chatbot.prueba.dto;

import chatbot.prueba.domain.Persona;

import java.util.List;

public class PersonaDto {

    private Integer idpersona;
    private String nombre;
    private String apellido;
    private String ci;
    private String telefono;

    //creamos lista de UsuarioDto en PersonaDto
    private List<UsuariosDto> usuariosList;

    public PersonaDto() {
    }

    public PersonaDto(Persona persona) {

        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.ci = persona.getCi();
        this.telefono = persona.getTelefono();
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /// get and set de UsuariosDto
    public List<UsuariosDto> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<UsuariosDto> usuariosList) {
        this.usuariosList = usuariosList;
    }
}
