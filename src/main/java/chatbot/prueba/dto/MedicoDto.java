package chatbot.prueba.dto;

import chatbot.prueba.domain.Medico;
import chatbot.prueba.domain.MedicoEspecialidad;
import java.util.Collection;

public class MedicoDto {

    private String nombres;
    private String apellidos;
    private Integer teléfono;
    private Collection<MedicoEspecialidad> medicoEspecialidadCollection;

    public MedicoDto() {
    }
    public MedicoDto(Medico medico) {
        this.nombres = medico.getNombres();
        this.apellidos = medico.getApellidos();
        this.teléfono = medico.getTeléfono();

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

    public Integer getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(Integer teléfono) {
        this.teléfono = teléfono;
    }

    public Collection<MedicoEspecialidad> getMedicoEspecialidadCollection() {
        return medicoEspecialidadCollection;
    }

    public void setMedicoEspecialidadCollection(Collection<MedicoEspecialidad> medicoEspecialidadCollection) {
        this.medicoEspecialidadCollection = medicoEspecialidadCollection;
    }
}
