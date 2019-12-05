package chatbot.prueba.dto;

public enum Estatus {

    //TIPOS DE DATOS
    ACTIVE(1), INACTIVE(0);

    //constructor


    Estatus(int estatus) {
        this.estatus = estatus;
    }

    private int estatus;
    //no se puede crear setters
    public int getEstatus() {
        return estatus;
    }
}
