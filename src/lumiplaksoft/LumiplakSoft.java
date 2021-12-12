package lumiplaksoft;

import Interfaces.Login;
import java.sql.*;
import javax.swing.*;
public class LumiplakSoft {

    Connection conectar = null;
    public Connection conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://mx58.hostgator.mx:3306/geminiso_Lumiplak", "geminiso_Lumi", "Lumiplak-21");
            JOptionPane.showMessageDialog(null, "conectado a la BD", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se a producido un error de tipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conectar;
        
    }
    
    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
    }
    
}
