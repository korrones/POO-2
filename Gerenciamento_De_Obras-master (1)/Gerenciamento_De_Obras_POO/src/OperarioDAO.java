import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {

    public void inserir(Operario operario) {
        String sql = "INSERT INTO Operario (Nome_Operario, Funcao) VALUES (?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operario> listar() {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT * FROM Operario";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operario operario = new Operario();
                operario.setIdOperario(rs.getInt("ID_Operario"));
                operario.setNomeOperario(rs.getString("Nome_Operario"));
                operario.setFuncao(rs.getString("Funcao"));
                operarios.add(operario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operarios;
    }
}
