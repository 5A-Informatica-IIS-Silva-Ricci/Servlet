import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Nazioni extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DbManager dbManager;
        try {
            dbManager = DbManager.getInstance();
            ArrayList<BeanNazione> nazioni = dbManager.getNazioni();
            req.setAttribute("nazioni", nazioni);
            req.getRequestDispatcher("nazioni.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.getOutputStream().print(PresentationManager.paginaErrore);
            e.printStackTrace();
        }
    }
}
