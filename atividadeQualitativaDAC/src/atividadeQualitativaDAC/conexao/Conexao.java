package atividadeQualitativaDAC.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
   
	private static final String URL = "jdbc:postgresql://localhost:5432/bdDAC";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "SUA_SENHA";

    public Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
