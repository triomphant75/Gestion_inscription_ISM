package core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mysql implements BaseDeDonne{
    protected Connection conn;
    protected PreparedStatement ps;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/revisionjava";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    public void ouvertureConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //java.sql.Connection 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    //la fermeture
    @Override
    public void fermetureConnexion() {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
        
    }
    
}
