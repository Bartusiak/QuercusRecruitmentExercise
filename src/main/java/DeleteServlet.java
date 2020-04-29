import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection conn = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId =  req.getParameter("param1");
        Integer id = Integer.parseInt(stringId);
        HttpSession session = req.getSession(false);

        try {
            conn = ConnectionManager.getConnection();
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM workers WHERE id=" + id + ";");
            statement.close();
            conn.close();
            session.setAttribute("message","Pracownik usunięty pomyślnie !");
            resp.sendRedirect("/recruitment_test/view/home.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
