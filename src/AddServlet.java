import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/addWorker")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Resource(name="jdbc/quercus")
    private DataSource dataSource;

    private final String url = "jdbc:postgresql:localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "QuercusBase2020";

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("workerName");
        String surname = request.getParameter("workerSurname");
        String email = request.getParameter("workerEmail");
        String address = request.getParameter("workerAddress");

        PrintWriter output = response.getWriter();
        response.setContentType("text/plain");

        if(validateEmail(email)==true){
            Database database = new Database();
            try {
                Worker worker = new Worker();
                worker.setWorkerName(name);
                worker.setWorkerSurname(surname);
                worker.setAddress(address);
                worker.setEmail(email);
                database.connect();
                database.insertWorkerData(worker,DriverManager.getConnection(url, user, password));
                database.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            output.println("Pracownik: " + name + " " + surname + " " + email + " " + address);
        }
        else{
            output.println("Wprowadzono niepoprawny email");
        }

    }

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
