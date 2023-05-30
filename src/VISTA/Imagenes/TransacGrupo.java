/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PK28.Imagenes;


public class TransacGrupo {
   public static  String user;
   public static  String passE;
   public static int nroEst;
    public static int nroNota;
   public static void  iniciar(){
       user="wdiaz";
       nroEst=1;
       nroNota=1;
       String passtemp= "MICODIGOSECRETO";
       try {
          passE=Seguridad.encriptar(passtemp); 
       } catch (Exception e) {
           System.out.println(e);
       }  
   }
public static boolean validarUser(String userx) {
    boolean r=false;
    if(userx.compareTo(user)==0){
        r=true;    
    }
    return r;
}
public static boolean validarPass(String passex) {
    boolean r=false;
    if(passex.compareTo(passE)==0){
        r=true;
         
    }
    return r;
}
}
