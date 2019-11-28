package chatbot.prueba.dto;

import chatbot.prueba.domain.Usuarios;

public class UsuariosDto {

    private Integer idusuarios;
    private String usuario;
    private String contrasena;

    public UsuariosDto() {
    }

    public UsuariosDto(Usuarios usuarios) {

        this.idusuarios = usuarios.getIdusuarios();
        this.usuario = usuarios.getUsuario();
        this.contrasena = usuarios.getContrasena();

    }


    public Integer getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
