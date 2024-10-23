/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import java.util.*;

import static java.sql.DriverManager.*;

/**
 * @author lucenabo
 */

public class ConexionMySQL {
    private final String BD;
    private final String USUARIO;
    private final String PASS;
    private final String HOST;

    Calendar now;
    TimeZone zonaHoraria;
    public Connection connection;

    public ConexionMySQL(String usuario, String pass, String bd) {
        this.USUARIO = usuario;
        this.PASS = pass;
        this.BD = bd;
        this.HOST = "localhost";
        connection = null ;
    }

    public void registrarDriver() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se ha encontrado el driver de MySQL");
        }
    }

    public void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            registrarDriver();
            Calendar now = Calendar.getInstance();
            zonaHoraria = now.getTimeZone();
            connection = getConnection("jdbc:mysql://" + HOST + "/" + BD + "?user=" + USUARIO + "&password=" + PASS + "&userLegacyDateTimeCode=false&serverTimeZone=" + zonaHoraria.getID());
        }
    }

    public boolean comprobarConexion() throws SQLException {
        return connection != null && !connection.isClosed();
    }

    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }

    public ResultSet ejectuarSelect(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(consulta);
        return rset;
    }

    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(consulta);
    }

    public boolean tablaExiste(String tabla) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, tabla, null);
        return tables.next();
    }

    public void crearTabla() throws SQLException {
        try {
            PreparedStatement st = null;
            st = connection.prepareStatement("CREATE TABLE banco(usuario VARCHAR(255), password VARCHAR(50), nombre VARCHAR(50), apellidos VARCHAR(50), saldo FLOAT, PRIMARY KEY(usuario))");
            st.execute();
            st.close();
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }

}
