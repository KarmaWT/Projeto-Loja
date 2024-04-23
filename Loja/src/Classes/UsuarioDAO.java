package Classes;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UsuarioDAO {
   Connection conexao;
   
   public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ResultSet AutenticarUsuario(Usuario usuario) throws SQLException {
        ResultSet resultado = null;
         PreparedStatement statement = null;
        try {
            // Preparar a consulta SQL para buscar o usuário com o nome de usuário e senha informados
            String sql = "SELECT * FROM USUARIO WHERE nome_usuario = ? AND senha = ?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());

            // Executar a consulta SQL e obter o resultado
            resultado = statement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro de Conexão: " + ex.getMessage());
            throw ex;
        } finally {
            // Fechar a declaração no bloco finally
            if (statement != null) {
                statement.close();
            }
            // A conexão não é fechada aqui, assumindo que ela será fechada pelo código que a chamou.
        }
        return resultado;
    }
}