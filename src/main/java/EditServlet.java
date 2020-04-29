import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection conn = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId =  req.getParameter("param1");
        Integer id = Integer.parseInt(stringId);
        String name = req.getParameter("param2");
        String surname = req.getParameter("param3");
        String address = req.getParameter("param4");
        String email = req.getParameter("param5");
        HttpSession session = req.getSession(false);
        session.setAttribute("workerId", id);
        session.setAttribute("workerName", name);
        session.setAttribute("workerSurname", surname);
        session.setAttribute("workerAddress", address);
        session.setAttribute("workerEmail", email);
        resp.sendRedirect("/recruitment_test/view/edit-worker.jsp");
    }
}
