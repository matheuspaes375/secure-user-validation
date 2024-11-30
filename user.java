package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // URL e credenciais (use variáveis de ambiente para maior segurança)
            String url = "jdbc:mysql://127.0.0.1/test";
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conn;
    }

    public String nome = "";
    public boolean verificarUsuario(String login, String senha) {
        boolean result = false;
        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection conn = conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, login);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
                result = true;
            }
        } catch (Exception e) {
            System.err.println("Erro ao verificar o usuário: " + e.getMessage());
        }
        return result;
    }
}

