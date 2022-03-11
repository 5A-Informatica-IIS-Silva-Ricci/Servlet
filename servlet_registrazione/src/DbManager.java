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

        setupDb();
    }

    public static DbManager getInstance() throws SQLException {
        if (instance == null)
            instance = new DbManager();

        return instance;
    }

    private void setupDb() throws SQLException {
        String setupQuery = "CREATE DATABASE IF NOT EXISTS tpsit;CREATE TABLE Studenti(id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(30) NOT NULL, cognome VARCHAR(30) NOT NULL);";
        PreparedStatement statement = connection.prepareStatement(setupQuery);
        statement.executeQuery();
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
