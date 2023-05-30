package CONTROL;

import MODELO.Estudiante;
import java.sql.*;
import java.util.ArrayList;


public class TransaccEst {
    public static ResultSet rs;
    
    //Metodos
    public static ArrayList cargar(){
        ArrayList losE = new ArrayList();
        String query = "SELECT* FROM ESTUDIANTE";
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        rs = con.consultar(query);
        Estudiante x;
        int idEst = 0;
        String apellido = "";
        String nombre = "";
        char sexo = ' ';
        String email = "";
        String dirRuta = "";
        String foto = "";
        try {
            while (rs.next()) {
                idEst = rs.getInt("IDESTUDIANTE");
                apellido = rs.getString("APELLIDO");
                nombre = rs.getString("NOMBRE");
                String ssexo = rs.getString("SEXO");
                sexo = ssexo.charAt(0);
                email = rs.getString("EMAIL");
                dirRuta = rs.getString("DIRRUTA");
                foto = rs.getString("NOMBREFOTO");
                x = new Estudiante(idEst, apellido, nombre,sexo,email,dirRuta,foto);
                losE.add(x);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return losE;
    }
    public static boolean adicionar(Estudiante x){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "INSERT INTO ESTUDIANTE values('"+
                x.getIdEst() +"','"+x.getApellido()+"','"+
                x.getNombre()+"','"+x.getSexo()+"','"+
                x.getEmail()+"','"+x.getDirRuta()+"','"+
                x.getFoto()+"')";
        
        r = con.actualizar(query);
        return r;
    }
    public static boolean modificar(Estudiante x){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "UPDATE ESTUDIANTE SET apellido = '"+x.getApellido()+
                "', nombre= '"+x.getNombre()+"', sexo = '"+x.getSexo()+"', email = '"+x.getEmail()+
                "', DIRRUTA = '"+x.getDirRuta()+"', NOMBREFOTO = '"+x.getFoto()+
                "' WHERE IDESTUDIANTE = "+x.getIdEst();
        r = con.actualizar(query);
        return r;
    }
    public static boolean eliminar(int idEstx){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "delete from ESTUDIANTE where idEstudiante="+ idEstx;
        return r;
    }
    public static Estudiante buscar(int idestx){
        Estudiante r = null;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "SELECT* FROM ESTUDIANTE WHERE IDESTUDIANTE="+idestx;
        ResultSet rs = con.consultar(query);
        int idEst = 0;
        String apellido = "";
        String nombre = "";
        char sexo = ' ';
        String email = "";
        String dirRuta = "";
        String foto = "";
        try{
            if (rs.next()) {
                idEst = rs.getInt("IDESTUDIANTE");
                apellido = rs.getString("APELLIDO");
                nombre = rs.getString("NOMBRE");
                String ssexo = rs.getString("SEXO");
                sexo = ssexo.charAt(0);
                email = rs.getString("EMAIL");
                dirRuta = rs.getString("DIRRUTA");
                foto = rs.getString("NOMBREFOTO");
                r = new Estudiante(idEst, apellido, nombre, sexo, email, dirRuta, foto);
            }
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
        return r;
    }
}
