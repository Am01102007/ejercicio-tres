package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class Conexion {
    private static Collection<Usuario> usuarios = new LinkedList<>();
    private String pass;
    private String codificacion;
    private int tiempoEspera;
    private byte reintentos;
    private boolean sst;
    private short port;
    private String baseDeDatos;

    private Conexion(String pass, String codificacion, int tiempoEspera, byte reintentos, boolean sst, short port, String baseDeDatos) {
        this.pass = pass;
        this.codificacion = codificacion;
        this.tiempoEspera = tiempoEspera;
        this.reintentos = reintentos;
        this.sst = sst;
        this.port = port;
        this.baseDeDatos = baseDeDatos;
    }

    private static Optional<Usuario> buscarUsuario(Usuario usuario) {
        Predicate<Usuario> nombreIgual = u -> u.getNombre().equals(usuario.getNombre());
        return usuarios.stream().filter(nombreIgual).findAny();
    }

    public static Conexion getInstance(String pass, String codificacion, int tiempoEspera, byte reintentos, boolean sst, short port, String baseDeDatos, Usuario usuario) throws Exception {
        Optional<Usuario> optionalUsuario = buscarUsuario(usuario);
        if (optionalUsuario.isPresent()) {
            throw new Exception("No se puede crear la conexión, el usuario ya existe");
        } else {
            Conexion nuevaConexion = new Conexion(pass, codificacion, tiempoEspera, reintentos, sst, port, baseDeDatos);
            usuarios.add(usuario); // Agregar usuario a la lista de usuarios
            return nuevaConexion;
        }
    }

    public String getPass() {
        return pass;
    }

    public String getCodificacion() {
        return codificacion;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public byte getReintentos() {
        return reintentos;
    }

    public boolean isSst() {
        return sst;
    }

    public short getPort() {
        return port;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public static class ConexionBuilder {
        private Usuario usuario;
        private String pass;
        private String codificacion;
        private int tiempoEspera;
        private byte reintentos;
        private boolean sst;
        private short port;
        private String baseDeDatos;

        public ConexionBuilder(Usuario usuario, String pass, String codificacion, int tiempoEspera, byte reintentos, boolean sst, short port, String baseDeDatos) {
            this.usuario = usuario;
            this.pass = pass;
            this.codificacion = codificacion;
            this.tiempoEspera = tiempoEspera;
            this.reintentos = reintentos;
            this.sst = sst;
            this.port = port;
            this.baseDeDatos = baseDeDatos;
        }

        public ConexionBuilder pass(String pass) {
            this.pass = pass;
            return this;
        }

        public ConexionBuilder codificacion(String codificacion) {
            this.codificacion = codificacion;
            return this;
        }

        public ConexionBuilder tiempoEspera(int tiempoEspera) {
            this.tiempoEspera = tiempoEspera;
            return this;
        }

        public ConexionBuilder reintentos(byte reintentos) {
            this.reintentos = reintentos;
            return this;
        }

        public ConexionBuilder sst(boolean sst) {
            this.sst = sst;
            return this;
        }

        public ConexionBuilder port(short port) {
            this.port = port;
            return this;
        }

        public ConexionBuilder baseDeDatos(String baseDeDatos) {
            this.baseDeDatos = baseDeDatos;
            return this;
        }

        public Conexion build() throws Exception {
            return Conexion.getInstance(this.pass, this.codificacion, this.tiempoEspera, this.reintentos, this.sst, this.port, this.baseDeDatos, this.usuario);
        }
    }
}