package chatbot.prueba.dto;


import chatbot.prueba.domain.Usuario;

import javax.persistence.Basic;
import javax.persistence.Column;

public class UsuariosDto {

    private Integer idusuario;
    private String botUserId;

    public UsuariosDto() {
    }

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
    }
}
