import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {
    private static DbManager instance = null;

    private final Connection connection;

    private DbManager() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tpsit",
                "root", ""
        );
    }

    public static DbManager getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (instance == null)
            instance = new DbManager();

        return instance;
    }

    public boolean registraStudente(String nome, String cognome) {
        String query = "INSERT INTO tpsit.studenti (nome, cognome) VALUES (?, ?)";
        System.out.println("Sono nella funzione studente "+nome+" "+cognome+" "+query);
        return eseguiQuery(nome, cognome, query);
    }

    public boolean registraDocente(String nome, String cognome) {
        String query = "INSERT INTO tpsit.docenti (nome, cognome) VALUES (?, ?)";
        System.out.println("Sono nella funzione docente "+nome+" "+cognome+" "+query);
        return eseguiQuery(nome, cognome, query);
    }

    public boolean eseguiQuery(String nome, String cognome, String query){
        try {
            System.out.println(nome+" "+cognome+" "+query);
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
