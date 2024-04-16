package Conexão;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "usuario";
    private static final String password = "1234";
    
    private static Connection conn;
    
    public static Connection getConexao() throws SQLException{

            try { 
                if(conn == null) {
                   conn = (Connection) DriverManager.getConnection(url, user, password);
                   return conn;
            } else { 
                    return conn;
        } 
            }catch (SQLException e){
            e.printStackTrace();
            return null;
            }
        }         
}
