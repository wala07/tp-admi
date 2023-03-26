

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

public class connexion {
    static String url = "jdbc:mysql://localhost:3306/bddgraph" ;
    static String user= "root";
    static String password ="root";
    public static Connection seConnecter() throws SQLException {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            conn = DriverManager.getConnection(url,user,password) ;
        }
        catch (ClassNotFoundException e){
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
            exit(0);
        }
        return conn;
    }
}