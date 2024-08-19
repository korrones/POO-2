import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instance;
    private Connection connection;
    private String url = "jdbc:sqlite:obras.db";

    private ConexaoBD() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }

    public static ConexaoBD getInstancia() {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        return instance;
    }

    public Connection getConexao() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {

        }
        return connection;
    }
}
