import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Studente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");

        DbManager dbManager;
        try {
            System.out.println("Sono all'interno della classe studente.java");
            dbManager = DbManager.getInstance();
            resp.getOutputStream().print(
                    dbManager.registraStudente(nome, cognome) ? PresentationManager.paginaSuccesso : PresentationManager.paginaErrore
            );
        } catch (Exception e) {
            resp.getOutputStream().print(PresentationManager.paginaErrore);
            e.printStackTrace();
        }
    }
}
