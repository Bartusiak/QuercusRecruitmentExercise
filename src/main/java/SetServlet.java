import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/setServlet")
public class SetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("workerId"));
        String name = req.getParameter("workerName");
        String surname = req.getParameter("workerSurname");
        String workerEmail = req.getParameter("workerEmail");
        String workerAddress = req.getParameter("workerAddress");

        PrintWriter output = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession(false);

        if(AddServlet.validateEmail(workerEmail)==true){
            try {
                conn = ConnectionManager.getConnection();
                statement = conn.prepareStatement("UPDATE workers SET worker_name=?, worker_surname=?, address=?, email=?" +
                        "WHERE id=" + id + ";");
                statement.setString(1,name);
                statement.setString(2,surname);
                statement.setString(3,workerAddress);
                statement.setString(4,workerEmail);
                statement.executeUpdate();
                statement.close();
                session.setAttribute("message","Pracownik edytowany pomyślnie !");
                resp.sendRedirect("/recruitment_test/view/home.jsp");

                //response.sendRedirect("/recruitment_test/view/home.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                output.close();
            }
        }
        else{
            output.println("Wprowadzono niepoprawny email (cofnij).");
        }

    }
}
