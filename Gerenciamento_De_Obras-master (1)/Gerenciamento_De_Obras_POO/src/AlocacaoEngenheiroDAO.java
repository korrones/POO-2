import java.sql.*;

public class AlocacaoEngenheiroDAO {

    public void alocarEngenheiro(int idProjeto, int idEngenheiro) {
        String sql = "INSERT INTO Alocacao_Engenheiro (ID_Projeto, ID_Engenheiro) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idEngenheiro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
