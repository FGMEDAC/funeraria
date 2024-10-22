/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funeraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MEDAC
 */
public class Funeraria {
    
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/funeraria";

    public static void main(String[] args) throws ClassNotFoundException {
        
            final String usuario = "root";
            final String password = "MEDAC";
            Connection dbConnection = null;
            Statement statement = null;
            Statement statement2 = null;
        
            try {
                Class.forName(DRIVER);
                Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
                String selectTableSQL = "SELECT * FROM cliente";
                
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(selectTableSQL);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            
    } 
}
