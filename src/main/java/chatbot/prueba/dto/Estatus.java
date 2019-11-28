package chatbot.prueba.dto;

public enum Estatus {
    ACTIVE(1), INACTIVE(0);

    private  int estatus;

    Estatus(int estatus) {
        this.estatus = estatus;
    }

    public int getEstatus() {
        return estatus;
    }
}
