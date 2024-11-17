
//steps to connect sql database to java class
// Register the driver class 
//Creating Connection String
//Creating Statemet
//Executing MySql Queries
//Closing the Connection



package management;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.sql.PreparedStatement;


public class Conn {
    
    java.sql.Connection c ;
    java.sql.Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = java.sql.DriverManager.getConnection("jdbc:mysql:///management", "root", "Vedant@123");//hotel
            
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
    
    
    
    
    
    
    
    
