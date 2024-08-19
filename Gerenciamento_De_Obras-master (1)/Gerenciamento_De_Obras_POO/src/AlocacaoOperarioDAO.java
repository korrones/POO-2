import java.sql.*;

public class AlocacaoOperarioDAO {

    public void alocarOperario(int idProjeto, int idOperario) {
        String sql = "INSERT INTO Alocacao_Operario (ID_Projeto, ID_Operario) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idOperario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
