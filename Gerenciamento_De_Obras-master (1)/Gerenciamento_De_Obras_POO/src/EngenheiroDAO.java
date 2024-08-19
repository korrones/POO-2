import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO {

    public void inserir(Engenheiro engenheiro) {
        String sql = "INSERT INTO Engenheiro (Nome_Engenheiro, Especialidade) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Engenheiro> listar() {
        List<Engenheiro> engenheiros = new ArrayList<>();
        String sql = "SELECT * FROM Engenheiro";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Engenheiro engenheiro = new Engenheiro();
                engenheiro.setIdEngenheiro(rs.getInt("ID_Engenheiro"));
                engenheiro.setNomeEngenheiro(rs.getString("Nome_Engenheiro"));
                engenheiro.setEspecialidade(rs.getString("Especialidade"));
                engenheiros.add(engenheiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engenheiros;
    }
}
