import java.sql.*;

public class ConsumoMaterialDAO {

    public void consumirMaterial(int idProjeto, int idMaterial) {
        String sql = "INSERT INTO Consumo_Material (ID_Projeto, ID_Material) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idMaterial);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
