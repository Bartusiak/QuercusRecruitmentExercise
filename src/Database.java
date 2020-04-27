import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private final String database_driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql:localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "QuercusBase2020";

    private Connection conn;

    public Connection connect() throws SQLException {

        if (conn==null) {
            try {
                Class.forName(database_driver);
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Successfull connected with PostgreSQL database !");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                conn.close();
            }
        }
        return conn;
    }

    public void disconnect(){
        if(conn != null){
            try{
                conn.close();
                conn=null;
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void insertWorkerData(Worker worker, Connection conn){
        String query = "INSERT INTO workers " +
                "("+ " worker_name," + " worker_surname," + " address," + " email VALUES " +
                "(" + "?,?,?,?)";
        try{
            PreparedStatement statement = null;
            statement = conn.prepareStatement(query);
            statement.setString(1,worker.getWorkerName());
            statement.setString(2,worker.getWorkerSurname());
            statement.setString(3,worker.getAddress());
            statement.setString(4,worker.getEmail());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
