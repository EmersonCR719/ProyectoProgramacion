package MODELO;

import CONTROL.Conexion;
import CONTROL.TransaccEst;
import CONTROL.TransaccNota;
import java.sql.Connection;
import java.sql.ResultSet;

public class Nota {
    //Atributos
    private int idNota;
    private char tipo;
    private double valor;
    private double porcentaje;
    private int idEst;
    private int corte;

    public Nota() {
        this.idNota = 0;
        this.tipo = ' ';
        this.valor = 0.0;
        this.porcentaje = 0.0;
        this.idEst = 0;
        this.corte = 0;
    }
    
    public Nota(int idNota, char tipo, double valor) {
        this.idNota = idNota;
        this.tipo = tipo;
        this.valor = valor;
        this.porcentaje = 0.0;
        this.idEst = 0;
        this.corte = 0;
    }

    public Nota(int idNota, char tipo, double valor, double porcentaje, int idEst, int corte) {
        this.idNota = idNota;
        this.tipo = tipo;
        this.valor = valor;
        this.porcentaje = porcentaje;
        this.idEst = idEst;
        this.corte = corte;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", tipo=" + tipo + ", valor=" +
                valor + ", porcentaje=" + porcentaje + ", idEst=" + idEst +
                ", corte=" + corte + "}\n";
    }
    
    //Datos que se muestarn en la el jtable:
    //Columnas
    public String[] getTitulos(){
        String[] tit= {"idNota","tipo","valor","porcentaje","idEst","corte"};
        return tit;
    }
    
    //Filas
    public String[]getDatos(){
        String[] datos = {Integer.toString(idNota), Character.toString(tipo),
        Double.toString(valor),Double.toString(porcentaje),Integer.toString(idEst),
        Integer.toString(corte)};
        return datos;
    } 
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Connection co = con.getConexion();
        ResultSet rs = con.consultar("SELECT* FROM NOTAS");
        try {
            while (rs.next()) {
                int idest = rs.getInt("IDESTUDIANTE");
                int contador=0;
                int i = 1;
                int idNota = 0;
                char tipo = ' ';
                double valor = 0.0;
                double porcentaje = 0.0;
                int corte = 1;
                while(i <= 4){
                    contador++;
                    idNota = 0;
                    tipo = (i%2==0)?'Q':'T';
                    valor = Math.random()*5.0;
                           valor = ((int)(valor*10))/10;
                    porcentaje = 0.0;
                    corte = 1;
                    Nota x = new Nota(idNota,tipo,valor,porcentaje,idest,corte);
                    TransaccNota.adicionar(x);
                    i++;
                }
                //Nota corte
                idNota = 0;
                tipo = 'C';
                valor = Math.random()*5.0;
                valor = ((int)(valor*10))/10;
                porcentaje = 0.4;
                corte = 1;
                Nota x = new Nota(idNota,tipo,valor,porcentaje,idest,corte);
                TransaccNota.adicionar(x);
                
                //Nota informe
                idNota = 0;
                tipo = 'I';
                valor = Math.random()*5.0;
                valor = ((int)(valor*10))/10;
                porcentaje = 0.3;
                corte = 1;
                x = new Nota(idNota,tipo,valor,porcentaje,idest,corte);
                TransaccNota.adicionar(x);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
        
    }
}
