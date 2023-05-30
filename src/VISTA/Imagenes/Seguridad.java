/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PK28.Imagenes;


import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author usuario
 */
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

