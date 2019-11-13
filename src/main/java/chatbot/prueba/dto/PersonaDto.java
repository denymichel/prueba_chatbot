package chatbot.prueba.dto;

public class PersonaDto {

    private Integer idPersona;
    private String nombres;
    private String apellidos;
    private int telefono;


    public PersonaDto() {
    }

    public PersonaDto(Persona persona) {
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.telefono = persona.getTelefono();
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
