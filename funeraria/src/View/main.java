
package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Controller.ConexionMySQL;
import Model.Cliente;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static ConexionMySQL conexion = new ConexionMySQL("root", "admin", "funeraria");
    public static ResultSet rset;
    public static Statement stmt;
    public ArrayList<Cliente> listaUsuario = new ArrayList<Cliente>();

    public static void main(String[] args) throws SQLException, SQLException {
        boolean a = true;
        while (a) {
            System.out.println("1. Conectar a la base de datos 2. Insertar o Update o Borrado 3. Consultas 4. Cerrar conexion ");
            int res = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (res) {
                case 1:
                    conexion.conectar();
                    conexion.comprobarConexion();
                    System.out.println("Se ha conectado a la base de datos");
                    break;
                case 2:
                    conexion.comprobarConexion();
                    System.out.println("Introduce la consulta que quieres hacer: 1. Insertar datos 2. Actualizar datos 3. Borrar datos");
                    int res2 = sc.nextInt();
                    sc.nextLine(); // Consumir la nueva línea
                    String tabla;
                    switch (res2) {
                        case 1:
                            System.out.println("Tablas disponibles");
                            rset = conexion.ejectuarSelect("SHOW TABLES");
                            while (rset.next()) {
                                System.out.println(rset.getString(1));
                            }
                            do {
                                System.out.println("En que tabla quieres insertar datos?");
                                tabla = sc.nextLine();
                                if (tabla == null || tabla.isEmpty() || !conexion.tablaExiste(tabla)) {
                                    System.out.println("Tabla no válida. Inténtalo de nuevo.");
                                } else {
                                    rset = conexion.ejectuarSelect("DESCRIBE " + tabla);
                                    System.out.println("Campos de la tabla " + tabla + ":");
                                    while (rset.next()) {
                                        System.out.println(rset.getString("Field"));
                                    }
                                    System.out.println("Nombre");
                                    String nombre = sc.nextLine();
                                    System.out.println("Telefono");
                                    String telefono = sc.nextLine();
                                    System.out.println("Email");
                                    String email = sc.nextLine();
                                    System.out.println("Direccion");
                                    String direccion = sc.nextLine();
                                    String datos = "'" + nombre + "', '" + telefono + "', '" + email + "', '" + direccion + "'";
                                    conexion.ejecutarInsertDeleteUpdate("INSERT INTO " + tabla + "(nombre, telefono, email, direccion) VALUES (" + datos + ")");
                                }
                            } while ( !conexion.tablaExiste(tabla) || tabla == null || tabla.isEmpty());
                            break;
                        case 2:
                            System.out.println("Introduce la consulta que quieres hacer");
                            String consulta3 = sc.nextLine();
                            rset = conexion.ejectuarSelect(consulta3);
                            while (rset.next()) {
                                System.out.println(rset.getString("nombre") + " " + rset.getString("telefono") + " " + rset.getString("email") + " " + rset.getString("direccion") + " " + rset.getInt("id"));
                            }
                            break;
                        case 3:
                            System.out.println("Introduce la consulta que quieres hacer");
                            String consulta4 = sc.nextLine();
                            conexion.ejecutarInsertDeleteUpdate(consulta4);
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtalo de nuevo.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Introduce lo que quieres hacer");
                    String consulta = sc.nextLine();
                    conexion.ejecutarInsertDeleteUpdate(consulta);
                    break;
                case 4:
                    conexion.desconectar();
                    System.out.println("Se ha cerrado la conexión");
                    a = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }


    }
}