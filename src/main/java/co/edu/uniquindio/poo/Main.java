package co.edu.uniquindio.poo;


/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
        try {
            Usuario user = new Usuario("ID1", "Juan");
            Conexion.ConexionBuilder builder = new Conexion.ConexionBuilder(user, "password", "UTF-8", 5000, (byte) 3, true, (short) 9000, "Students");
            Conexion conn = builder.build();
            System.out.println(conn);

            // Intentar crear otra instancia con el mismo usuario
            Conexion.ConexionBuilder builder2 = new Conexion.ConexionBuilder(user, "password2", "UTF-8", 5000, (byte) 3, true, (short) 9001, "Students");
            Conexion conn2 = builder2.build();
            System.out.println(conn2);
        } catch (Exception e) {
            System.out.println("Error al crear la conexión: " + e.getMessage());
        }
    }
}



