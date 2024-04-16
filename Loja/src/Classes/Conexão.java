
package Classes;

import java.sql.*;

public class Conexão {

    public static void main(String[] args) throws SQLException {
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "usuario", "1234");
            ResultSet rsUsuario = conexao.createStatement().executeQuery("SELECT * FROM USUARIO");
            while (rsUsuario.next()){
                System.out.println("Nome: " + rsUsuario.getNString("nome"));
                System.out.println("Senha: " + rsUsuario.getNString("senha"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }        
}

