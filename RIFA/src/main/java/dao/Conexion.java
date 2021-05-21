package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "KALIDA", "KALIDA");
//            Class.forName("oracle.jdbc.pool.OracleDataSource");
//            cnx = DriverManager.getConnection("jdbc:oracle:thin:@kalidaoracle1_tp?TNS_ADMIN=./wallet_KALIDAORACLE1", "ADMIN", "KalidaOracle1");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // cnx = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=dbServiSoft", "sa", "Administrador2021");
            cnx = DriverManager.getConnection("jdbc:sqlserver://FernandoCanales;databaseName=dbServiSoft", "sa", "Administrador2021");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        
        return cnx;
    }

    public static void cerrarCnx() throws Exception {
        if(Conexion.cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        conectar();
        if (cnx != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Sin Conexión");
        }
    }

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection aCnx) {
        cnx = aCnx;
    }

}