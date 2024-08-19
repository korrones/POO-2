import java.sql.*;

public class UsoEquipamentoDAO {

    public void usarEquipamento(int idProjeto, int idEquipamento) {
        String sql = "INSERT INTO Uso_Equipamento (ID_Projeto, ID_Equipamento) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idEquipamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
