package CONTROL;

import MODELO.Estudiante;
import MODELO.Nota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TransaccNota {
    public static ResultSet rs;
    
    //Metodos
    public static ArrayList cargar(){
        ArrayList lasN = new ArrayList();
        String query = "SELECT* FROM NOTAS";
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        rs = con.consultar(query);
        Nota x;
        int idNota = 0;
        char tipo = ' ';
        double valor = 0.0;
        double porcentaje = 0.0;
        int idEst = 0;
        int corte = 0;
        try {
            while (rs.next()) {
                idNota = rs.getInt("IDNOTA");
                String stipo = rs.getString("TIPO");
                tipo = stipo.charAt(0);
                valor = rs.getDouble("VALOR");
                porcentaje = rs.getDouble("PORCENTAJE");
                idEst = rs.getInt("IDESTUDIANTE");
                corte = rs.getInt("CORTE");
                x = new Nota(idNota,tipo,valor,porcentaje,idEst,corte);
                lasN.add(x);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lasN;
    }
    public static boolean adicionar(Nota x){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "INSERT INTO NOTAS values("+
                "NULL" +",'"+x.getTipo()+"',"+
                x.getValor()+","+x.getPorcentaje()+","+
                x.getIdEst()+","+x.getCorte()+ ")";
        
        
        r = con.actualizar(query);
        return r;
    }
    public static boolean modificar(Nota x){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "UPDATE NOTAS SET  tipo = '"+x.getTipo()+
                "', valor= '"+x.getValor()+"', porcentaje = '"+x.getPorcentaje()
                +" idest = "+x.getIdEst()+
                "', corte = '"+x.getCorte()+
                "' WHERE IDNota = '"+x.getIdNota()+"'";
        r = con.actualizar(query);
        System.out.println(query);
        return r;
    }
    public static boolean eliminar(int idNotax){
        boolean r = true;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "delete from NOTAS where idNota= "+ idNotax;
        return r;
    }
    public static Nota buscar(int idNotax){
        Nota r = null;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "SELECT* FROM NOTAS WHERE IDNota= "+idNotax;
        ResultSet rs = con.consultar(query);
        int idNota = 0;
        char tipo = ' ';
        double valor = 0.0;
        double porcentaje = 0.0;
        int idEst = 0;
        int corte = 0;
        try{
            if (rs.next()) {
                idNota = rs.getInt("IDNOTA");
                String stipo = rs.getString("TIPO");
                tipo = stipo.charAt(0);
                valor = rs.getDouble("VALOR");
                porcentaje = rs.getDouble("PORCENTAJE");
                idEst = rs.getInt("IDESTUDIANTE");
                corte = rs.getInt("CORTE");
                r = new Nota(idNota, tipo, valor, porcentaje, idEst, corte);
            }
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
        return r;
    }
    
    public static ArrayList cargarNotaEstudiante(int idestx){
        ArrayList lasN = new ArrayList();
        String query = "SELECT* FROM NOTAS WHERE IDESTUDIANTE= "+idestx;
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        rs = con.consultar(query);
        Nota x;
        int idNota = 0;
        char tipo = ' ';
        double valor = 0.0;
        double porcentaje = 0.0;
        int idEst = 0;
        int corte = 0;
        try {
            while (rs.next()) {
                idNota = rs.getInt("IDNOTA");
                String stipo = rs.getString("TIPO");
                tipo = stipo.charAt(0);
                valor = rs.getDouble("VALOR");
                porcentaje = rs.getDouble("PORCENTAJE");
                idEst = rs.getInt("IDESTUDIANTE");
                corte = rs.getInt("CORTE");
                x = new Nota(idNota,tipo,valor,porcentaje,idEst,corte);
                lasN.add(x);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lasN;
    }
    
    //CALCULOS DE NOTAS
    
    public static void calcularPromedioYCantQT(int ideestx){
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        String query = "SELECT AVG(VALOR) PRO, COUNT(*) CTA FROM NOTAS "+
                       " WHERE IDESTUDIANTE = "+ideestx+ " AND (TIPO='Q' or TIPO = 'T')";
        rs = con.consultar(query);
        Calculos.promedio = 0.0;
        Calculos.nroQyT = 0;
        try{
            if (rs.next()) {
                double prom = rs.getDouble("PRO");
                int cuenta = rs.getInt("CTA");
                Calculos.promedio = prom;
                Calculos.nroQyT = cuenta;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        query = "SELECT VALOR FROM NOTAS "+
                " WHERE IDESTUDIANTE= " + ideestx + " AND (TIPO = 'I')";
        Calculos.notaInformeProy = 0.0;
        rs = con.consultar(query);
        
        try{
            if (rs.next()) {
                double notaInf = rs.getDouble("VALOR");
                Calculos.notaInformeProy = notaInf;
            }
        }catch(Exception e){
            System.out.println(e);  
        }
        query = "SELECT VALOR FROM NOTAS "+
                " WHERE IDESTUDIANTE= " + ideestx + " AND (TIPO = 'C')";
        Calculos.examenCorte = 0.0;
        rs = con.consultar(query);
        
        try{
            if (rs.next()) {
                double notaEC = rs.getDouble("VALOR");
                Calculos.examenCorte = notaEC;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        if (Calculos.nroQyT != 0) {
            Calculos.porcentaje = 0.3/Calculos.nroQyT;
            Calculos.porcentaje = (int)(Calculos.porcentaje*10)/10.0;
        }
        Calculos.definitivaCorte = 0.0;
        Calculos.definitivaCorte = Calculos.promedio*0.3 + Calculos.examenCorte*0.4 +
                Calculos.notaInformeProy*0.3;
        Calculos.definitivaCorte = ((int)(Calculos.definitivaCorte*10))/10.0;
        if (Calculos.nroQyT != 0) {
        query = "UPDATE NOTAS SET PORCENTAJE = "+Calculos.porcentaje+
                       " WHERE IDESTUDIANTE = "+ideestx+" AND (TIPO = 'Q' or TIPO = 'T')";
        con.actualizar(query);
        }
        
        System.out.println(query);
    }
    
    public static void main(String[] args) {
        
        
        
       
    }
    
}
