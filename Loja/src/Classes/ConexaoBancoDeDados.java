package Classes;

import java.sql.*;

public class ConexaoBancoDeDados {

    private Connection conexao;

    public ConexaoBancoDeDados() throws SQLException {
        //Aqui se foi minha sanidade toda.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "12345");
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
            throw new SQLException("Driver não encontrado", ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
            throw ex;  
        }
    }

    public Connection getConnection() {
        return this.conexao;
    }

    public void close() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException ex) {
                System.out.println("Ocorreu um erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
