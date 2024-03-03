package co.edu.uniquindio.poo;

class Usuario {
    private final String identificacion;
    private final String nombre;

    public Usuario(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }
}

