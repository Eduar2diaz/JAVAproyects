
package proyectobd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class conectar {
    Connection conectar=null;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/hotelvice?user=root&password=");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conectar;
    }
    
    public ResultSet visualizarComida(){
        Connection con = conexion();
        ResultSet xd = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM comidas ");
            xd = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
        }
        return xd;
    }
    
    public ResultSet visualizarCuartos(){
        Connection con = conexion();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cuartos ");
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
        }
        
        return rs;
    }
}