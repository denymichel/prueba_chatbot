package chatbot.prueba.dto;

<<<<<<< HEAD

import chatbot.prueba.domain.Usuario;

import javax.persistence.Basic;
import javax.persistence.Column;

public class UsuariosDto {

    private Integer idusuario;
    private String botUserId;
=======
import chatbot.prueba.domain.Usuarios;

public class UsuariosDto {

    private Integer idusuarios;
    private String usuario;
    private String contrasena;
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a

    public UsuariosDto() {
    }

<<<<<<< HEAD
    public UsuariosDto(Usuario usuario) {
        this.idusuario = usuario.getIdusuario();
        this.botUserId = usuario.getBotUserId();
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
=======
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
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
    }
}
