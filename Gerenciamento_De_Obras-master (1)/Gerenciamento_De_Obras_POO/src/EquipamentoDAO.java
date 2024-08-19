import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    public void inserir(Equipamento equipamento) {
        String sql = "INSERT INTO Equipamento (Nome_Equipamento, Tipo) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipamento> listar() {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM Equipamento";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setIdEquipamento(rs.getInt("ID_Equipamento"));
                equipamento.setNomeEquipamento(rs.getString("Nome_Equipamento"));
                equipamento.setTipo(rs.getString("Tipo"));
                equipamentos.add(equipamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipamentos;
    }
}
