package CONTROL;

import java.sql.Connection;
import java.sql.ResultSet;


public class TransaccGrupo {
    
    public static  String user;
    public static  String passE;
    public static int nroEst;
    public static int nroNota;

    public static void  iniciar(){
        user = "ealbornoz";
        nroEst = 1;
        nroNota = 1;
        String passtemp = "MICODIGOSECRETO";
        try {
          passE = Seguridad.encriptar(passtemp); 
        } catch (Exception e) {
           System.out.println(e);
        }  
    }
    public static boolean validarUseryPass(String userx, String passEx) {
        boolean r=false;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        
        ResultSet rs = con.consultar("SELECT* FROM GRUPO");
        try {
            while (rs.next()) {
                String user = rs.getString("USER");
                String passE = rs.getString("PASSE");
                if(userx.compareTo(user)== 0 && (passEx.compareTo(passE) == 0)){
                    r=true;    
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return r;
    }
    
    /*
    public static boolean validarPass(String passex) {
        boolean r=false;
        if(passex.compareTo(passE)==0){
            r=true; 
        }
    return r;
    }
    */
}
