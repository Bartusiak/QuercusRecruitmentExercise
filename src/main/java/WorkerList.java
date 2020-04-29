import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/workerList")
public class WorkerList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection conn = null;
    private Statement statement = null;
    private ResultSet resultSet = null;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession(false);
            RequestDispatcher rd = req.getRequestDispatcher("worker-list.jsp");
            String str = "";
            try {
                conn = ConnectionManager.getConnection();
                statement = conn.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM workers");
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("worker_name");
                    String surname = resultSet.getString("worker_surname");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    System.out.println(id + " " + name + " " + surname +  " " + address + " " + email + "\n");
                    str += ("<tr><td>" + id + "</td><td>" + name + "</td><td>" + surname
                            + "</td><td>" + address + "</td><td>" + email + "</td>"
                            + "<td><a href=\"editServlet?param1=" + id + "&param2="
                            + name + "&param3=" + surname + "&param4=" + address + "&param5="
                            + email +"\">Edytuj</a></td>"
                            + "<td><a href=\"deleteServlet?param1=" + id + "\">Usuń</a></td></tr>");
                }
                statement.close();
                resultSet.close();
                conn.close();
                session.setAttribute("string", str);
                resp.sendRedirect("/recruitment_test/view/worker-list.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
