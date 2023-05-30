package CONTROL;

import java.io.UnsupportedEncodingException;
import java.util.Base64;



public class Seguridad {
    
    public  static String encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
   
    public static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }  
    
    public static void main(String[] args) {
        String cadenaDeTexto = "MICODIGOSECRETO";
        String cadenaEncriptada = "";
        try {
            System.out.println("Cadena original > "+cadenaDeTexto);
            cadenaEncriptada = encriptar(cadenaDeTexto);
            System.out.println("Cadena encriptada > "+cadenaEncriptada);
            String cadenaDesencriptada = desencriptar(cadenaEncriptada);
            System.out.println("Cadena desencriptada > "+cadenaDesencriptada);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Ups!! > "+e);
        }
    }
   
}
