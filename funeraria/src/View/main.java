
package View;
import java.sql.*;
import java.util.*;
import Controller.ConexionMySQL;

public class main {
    Scanner sc = new Scanner (System.in);
    ConexionMySQL conexion = new ConexionMySQL("root", "MEDAC", "funeraria");
    
    public static void main(String[] args) {
        System.out.println("1. Conectar a la base de datos 2. Insertar 3. Update 4. Borrado 5. Consultas 6. Cerrar conexion ");
        int res = sc.nextInt();
        
        switch (res){
            case 1:
                
            case 2: 
                
            case 3:
                
            case 4:
                
            case 5: 
                
            case 6:
        }
        
    }
}
