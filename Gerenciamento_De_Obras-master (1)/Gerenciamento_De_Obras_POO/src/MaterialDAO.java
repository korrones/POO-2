import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void inserir(Material material) {
        String sql = "INSERT INTO Material (Nome_Material, Quantidade) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, material.getNomeMaterial());
            stmt.setInt(2, material.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> listar() {
        List<Material> materiais = new ArrayList<>();
        String sql = "SELECT * FROM Material";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Material material = new Material();
                material.setIdMaterial(rs.getInt("ID_Material"));
                material.setNomeMaterial(rs.getString("Nome_Material"));
                material.setQuantidade(rs.getInt("Quantidade"));
                materiais.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiais;
    }
}
