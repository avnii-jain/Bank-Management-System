package bank.management.system;
import java.sql.*;

public class Conn {
    
    Connection c ;
    Statement st;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankmanagementsystem", 
                    "root", 
                    "Qwertyuiop");
            
            st = c.createStatement(); //Creating Statement
            
            System.out.println("Connected to DB. Tables:");
            ResultSet rs = st.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
    }
        } catch (Exception b ) {
            System.out.println("Database error: " + b);
        }
    }  
}
