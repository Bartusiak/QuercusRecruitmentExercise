import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String database_driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/quercus";
    private static String user = "postgres";
    private static String password = "QuercusBase2020";
    private static Connection conn;

    public static Connection getConnection(){
        try{
            Class.forName(database_driver);
            try{
                conn= DriverManager.getConnection(url,user,password);
            }catch (SQLException e){
                System.out.println("Failed database connection: " + e.getMessage());
            }
        }catch (ClassNotFoundException e){
            System.out.println("Driver not found: " + e.getMessage());
        }
        return conn;
    }


}
