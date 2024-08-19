import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    public void inserir(Projeto projeto) {
        String sql = "INSERT INTO Projeto (Nome_Projeto, Local, Data_Inicio, Data_Termino) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setString(3, projeto.getDataInicio());
            stmt.setString(4, projeto.getDataTermino());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM Projeto";
        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setIdProjeto(rs.getInt("ID_Projeto"));
                projeto.setNomeProjeto(rs.getString("Nome_Projeto"));
                projeto.setLocal(rs.getString("Local"));
                projeto.setDataInicio(rs.getString("Data_Inicio"));
                projeto.setDataTermino(rs.getString("Data_Termino"));
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }
}
