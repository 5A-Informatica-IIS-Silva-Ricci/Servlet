import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {
    private static DbManager instance = null;

    private final Connection connection;

    private DbManager() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/tpsit",
                "root", ""
        );
    }

    public static DbManager getInstance() throws SQLException {
        if (instance == null)
            instance = new DbManager();

        return instance;
    }

    public boolean registraUtente(String nome, String cognome) {
        String query = "INSERT INTO Studenti (nome, cognome) VALUES (?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
