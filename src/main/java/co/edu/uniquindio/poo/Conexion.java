package co.edu.uniquindio.poo;

    public class Conexion{
        private static String username;
        private String pass;
        private String codificacion;
        private int tiempoEspera;
        private byte reintentos;
        private boolean sst;
        private short port;
        private String baseDeDatos;
        private Conexion(String username, String pass, String codificacion, int tiempoEspera, byte reintentos, boolean sst,short port, String baseDeDatos) {
            this.pass = pass;
            this.codificacion = codificacion;
            this.tiempoEspera = tiempoEspera;
            this.reintentos = reintentos;
            this.sst = sst;
            this.port = port;
            this.baseDeDatos = baseDeDatos;
        }
        public static getInstance(){

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
        private String username;
        private String pass;
        private String codificacion;
        private int tiempoEspera;
        private byte reintentos;
        private boolean sst;
        private short port;
        private String baseDeDatos;
        public ConexionBuilder(String username, String pass, String codificacion, int tiempoEspera, byte reintos, boolean sst, short port, String basedeDatos) {
            this.username = username;
            this.pass = pass;
            this.codificacion = codificacion;
            this.tiempoEspera = tiempoEspera;
            this.reintentos = reintos;
            this.sst = sst;
            this.port = port;
            this.baseDeDatos = basedeDatos;
        }
        public ConexionBuilder username(String username){
            this.username=username;
            return this;
        }
        public ConexionBuilder pass(String pass){
            this.pass=pass;
            return this;
        }
        public ConexionBuilder codificacion(String codificacion){
            this.codificacion=codificacion;
            return this;
        }
        public ConexionBuilder reintentos(byte reintentos){
            this.reintentos=reintentos;
            return this;
        }
        public ConexionBuilder sst(boolean sst){
            this.sst=sst;
            return this;
        }
        public ConexionBuilder port(short port){
            this.port=port;
            return this;
        }
        public ConexionBuilder baseDeDatos(String baseDeDatos){
            this.baseDeDatos=baseDeDatos;
            return this;
        }
        public Conexion build(){
            return new Conexion(this.username, this.pass,this.codificacion, this.tiempoEspera, this.reintentos, this.sst, this.port, this.baseDeDatos);
        }

    }
    }