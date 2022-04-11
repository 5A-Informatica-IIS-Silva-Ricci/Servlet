import java.sql.*;
import java.util.ArrayList;

public class DbManager {
    private static DbManager instance = null;
    private static String nomeDb = "lunedi_5ai";
    private static String nomeTabella = "nazioni";

    private final Connection connection;

    private DbManager() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + nomeDb,
                "tpsit", "tpsit"
        );
    }

    public static DbManager getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (instance == null)
            instance = new DbManager();

        return instance;
    }

    public ArrayList<BeanNazione> getNazioni() throws SQLException {
        ArrayList<BeanNazione> nazioni = new ArrayList<>();
        String query = "SELECT * FROM " + nomeTabella + ";";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String nazione = rs.getString("nazione");
            String sigla = rs.getString("sigla");

            nazioni.add(new BeanNazione(nazione, sigla));
        }

        return nazioni;
    }

    /*
    public boolean registraUtente(String nome, String cognome) {
        String query = "INSERT INTO " + nomeTabella + " (nome, cognome) VALUES (?, ?)";

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
     */

    /*
    public boolean registraDocente(String nome, String cognome) {
        String query = "INSERT INTO Docenti (nome, cognome) VALUES (?, ?)";

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

     */
}
