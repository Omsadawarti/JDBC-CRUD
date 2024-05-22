package org.nlt.view;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public interface ParentInterface 
{
    public String frameTitle  = "Persone CRUDE";
public Connection con = getDataBaseConnection();
 public PersonFrame personFrame = new PersonFrame();
 public LoginFrame loginFrame = new LoginFrame();
 public static Connection getDataBaseConnection()
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/testproject2023","root",null);
     }
     catch(Exception ex)
     {
         JOptionPane.showMessageDialog(null, ex);
         return null;
     }
 }
}
