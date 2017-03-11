package Model;


import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

public class Conexion {
   private static Connection conn = null;
    private static String url = "jdbc:sql://localhost:8080/bdproduccion";
    private static String user = "sa";
    private static String pass = "alumno";
    private static ResultSet rs;
    private static PreparedStatement st;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection(url, user, pass);
            if(conn != null)
                return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException ex){
            return null;
        }
        return conn;
    }
}
