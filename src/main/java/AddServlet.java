import javax.annotation.Resource;
import javax.faces.annotation.RequestMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //@Resource(name="jdbc/quercus")
    //private DataSource dataSource;

    private Connection conn = null;
    private PreparedStatement statement = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("workerName");
        String surname = request.getParameter("workerSurname");
        String email = request.getParameter("workerEmail");
        String address = request.getParameter("workerAddress");

        PrintWriter output = response.getWriter();
        response.setContentType("text/plain");

        HttpSession session = request.getSession(false);

        if(validateEmail(email)==true){
            try {
                Worker worker = new Worker();
                worker.setWorkerName(name);
                worker.setWorkerSurname(surname);
                worker.setAddress(address);
                worker.setEmail(email);
                conn = ConnectionManager.getConnection();
                statement = conn.prepareStatement("INSERT INTO workers " +
                        "("+ " worker_name," + " worker_surname," + " address," + " email" + ")" + " VALUES " +
                        "(" + "?,?,?,?)");
                statement.setString(1,worker.getWorkerName());
                statement.setString(2,worker.getWorkerSurname());
                statement.setString(3,worker.getAddress());
                statement.setString(4,worker.getEmail());
                statement.executeUpdate();
                statement.close();
                session.setAttribute("message","Pracownik dodany do bazy danych");
                response.sendRedirect("/recruitment_test/view/home.jsp");

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

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
