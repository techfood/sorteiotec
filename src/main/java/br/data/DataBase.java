import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {
  
    public Connection conn = null;

    public DataBase() {

        String url = "jdbc:postgresql://localhost/sorteiotec";
        String driver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "12345";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "Erro...",
                    JOptionPane.WARNING_MESSAGE
            );
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}