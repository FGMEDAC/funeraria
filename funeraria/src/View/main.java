
package View;
import java.sql.*;
import java.util.*;
import Controller.ConexionMySQL;

public class main {
    public static Scanner sc = new Scanner (System.in);
    public static ConexionMySQL conexion = new ConexionMySQL("root", "MEDAC", "funeraria");
    
    public static void main(String[] args) throws SQLException {
        System.out.println("1. Conectar a la base de datos 2. Insertar o Update o Borrado 3. Consultas 4. Cerrar conexion ");
        int res = sc.nextInt();
        boolean a = true;
        
        do {
            switch (res){
            case 1:
                conexion.conectar();
                conexion.comprobarConexion();
                System.out.println("Se ha conectado a la base de datos");
                break;
            case 2: 
                System.out.println("Introduce lo que quieres hacer");
                String consulta = sc.nextLine();
                conexion.ejecutarInsertDeleteUpdate(consulta);
                break;
            case 3:
                
                break;
            case 4:
             
                break;
        }
        } while (a = false);
        
        
    }
}
