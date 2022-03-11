import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    private DbManager dbManager = null;

    public Servlet() {
        try {
            dbManager = DbManager.getInstance();
        } catch (Exception e) {
            System.out.println("Errore servlet registrazione studenti:\n" + e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");

        resp.getOutputStream().print(
                dbManager.registraUtente(nome, cognome) ? PresentationManager.paginaSuccesso : PresentationManager.paginaErrore
        );
    }
}
