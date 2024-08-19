import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

    public void criarTabelas() {
        String sqlProjeto = "CREATE TABLE IF NOT EXISTS Projeto (ID_Projeto INTEGER PRIMARY KEY AUTOINCREMENT, Nome_Projeto TEXT, Local TEXT, Data_Inicio TEXT, Data_Termino TEXT)";
        String sqlEngenheiro = "CREATE TABLE IF NOT EXISTS Engenheiro (ID_Engenheiro INTEGER PRIMARY KEY AUTOINCREMENT, Nome_Engenheiro TEXT, Especialidade TEXT)";
        String sqlOperario = "CREATE TABLE IF NOT EXISTS Operario (ID_Operario INTEGER PRIMARY KEY AUTOINCREMENT, Nome_Operario TEXT, Funcao TEXT)";
        String sqlEquipamento = "CREATE TABLE IF NOT EXISTS Equipamento (ID_Equipamento INTEGER PRIMARY KEY AUTOINCREMENT, Nome_Equipamento TEXT, Tipo TEXT)";
        String sqlMaterial = "CREATE TABLE IF NOT EXISTS Material (ID_Material INTEGER PRIMARY KEY AUTOINCREMENT, Nome_Material TEXT, Quantidade INTEGER)";
        String sqlAlocacaoEngenheiro = "CREATE TABLE IF NOT EXISTS Alocacao_Engenheiro (ID_Projeto INTEGER, ID_Engenheiro INTEGER, PRIMARY KEY (ID_Projeto, ID_Engenheiro), FOREIGN KEY (ID_Projeto) REFERENCES Projeto(ID_Projeto), FOREIGN KEY (ID_Engenheiro) REFERENCES Engenheiro(ID_Engenheiro))";
        String sqlAlocacaoOperario = "CREATE TABLE IF NOT EXISTS Alocacao_Operario (ID_Projeto INTEGER, ID_Operario INTEGER, PRIMARY KEY (ID_Projeto, ID_Operario), FOREIGN KEY (ID_Projeto) REFERENCES Projeto(ID_Projeto), FOREIGN KEY (ID_Operario) REFERENCES Operario(ID_Operario))";
        String sqlUsoEquipamento = "CREATE TABLE IF NOT EXISTS Uso_Equipamento (ID_Projeto INTEGER, ID_Equipamento INTEGER, PRIMARY KEY (ID_Projeto, ID_Equipamento), FOREIGN KEY (ID_Projeto) REFERENCES Projeto(ID_Projeto), FOREIGN KEY (ID_Equipamento) REFERENCES Equipamento(ID_Equipamento))";
        String sqlConsumoMaterial = "CREATE TABLE IF NOT EXISTS Consumo_Material (ID_Projeto INTEGER, ID_Material INTEGER, PRIMARY KEY (ID_Projeto, ID_Material), FOREIGN KEY (ID_Projeto) REFERENCES Projeto(ID_Projeto), FOREIGN KEY (ID_Material) REFERENCES Material(ID_Material))";

        try (Connection conexao = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conexao.createStatement()) {

            stmt.execute(sqlProjeto);
            stmt.execute(sqlEngenheiro);
            stmt.execute(sqlOperario);
            stmt.execute(sqlEquipamento);
            stmt.execute(sqlMaterial);
            stmt.execute(sqlAlocacaoEngenheiro);
            stmt.execute(sqlAlocacaoOperario);
            stmt.execute(sqlUsoEquipamento);
            stmt.execute(sqlConsumoMaterial);

            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
