package CONTROL;
import java.sql.*;
public class Conexion {
    Connection con;
    
    //Metodos
    //Para hacer la coneccion a la base de datos
    public Connection getConexion() {
        Connection r = null;
        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://localhost/proydb";
        
        try{
            Class.forName(sDriver);
            con = DriverManager.getConnection(sURL,"root","");
            r = con;
            System.out.println("¡¡CONEXION EXITOSA!!");
            
        }catch(ClassNotFoundException ex){
            System.out.println("Error al registrar el driver de MySQL: "+ ex);
        }catch(SQLException ex){
            System.out.println("Error exception SQL" + ex);
        }
        return r;     
    }
    
    public ResultSet consultar(String consulta){
        ResultSet rs = null;
        try{
            PreparedStatement ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            System.out.println("Consulta exitosa");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error exception SQL" + e);
        }
        return rs;
    }
    public boolean actualizar(String query){
        boolean r = true;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("Update exitosa");
        }catch(Exception e){
            r = false;
            System.out.println(e);
        }
        return r;
    }
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        
        ResultSet rs = con.consultar("SELECT* FROM NOTAS");
        try {
            while (rs.next()) {
                int idest = rs.getInt("IDESTUDIANTE");
                String valor = rs.getString("VALOR");
                System.out.print(idest+" ");
                System.out.println(valor);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
        try {
            String pass = "MICODIGOSECRETO";
            String passE = Seguridad.encriptar(pass);
            String query = "UPDATE GRUPO SET PASSE ='"+passE+"' WHERE IDCURSO=341";
            con.actualizar(query);
            System.out.println("Very good");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
