
package View;
import java.sql.*;
import java.util.*;
import Controller.ConexionMySQL;

public class App {
    public static Scanner sc = new Scanner (System.in);
    public static ConexionMySQL conexion = new ConexionMySQL("root", "admin", "funeraria");
    
    public static void main(String[] args) throws SQLException {
        System.out.println("1. Conectar a la base de datos 2. Insertar 3. Update 4. Borrado 5. Consultas 6. Cerrar conexion ");
        int res = sc.nextInt();
        
        switch (res){
            case 1:
                conexion.comprobarConexion();
            case 2: 
                
            case 3:
                
            case 4:
                
            case 5: 
                
            case 6:
        }
        
    }
}
