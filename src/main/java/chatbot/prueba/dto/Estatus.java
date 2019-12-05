package chatbot.prueba.dto;

public enum Estatus {
<<<<<<< HEAD

    //TIPOS DE DATOS
    ACTIVE(1), INACTIVE(0);

    //constructor

=======
    ACTIVE(1), INACTIVE(0);

    private  int estatus;
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a

    Estatus(int estatus) {
        this.estatus = estatus;
    }

<<<<<<< HEAD
    private int estatus;
    //no se puede crear setters
=======
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
    public int getEstatus() {
        return estatus;
    }
}
