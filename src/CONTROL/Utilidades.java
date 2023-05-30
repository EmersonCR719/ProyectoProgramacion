package CONTROL;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utilidades {
    
    public static final int NINGUNO=-1;
    
    public static boolean esEntero(String a){
        boolean r = true;
        int x=0;
        try{
           x=Integer.parseInt(a);
           r = true;
        }catch(Exception  e){
            r=false;
        }
        return r;
    } 
    public static boolean esReal(String a){
        boolean r = true;
        double x=0;

        return r;
    } 

    public static boolean estavacio(String x){
        boolean r= true;
        r= x.length()==0; //tue false
        return r;
    }

    public static boolean sonEspacios(String x){
        String CadenaSinBlancos="";
        StringTokenizer stTexto = new StringTokenizer(x);

        while (stTexto.hasMoreElements())
          CadenaSinBlancos += stTexto.nextElement();   
         // si no es ==0  es porque habia algo alli eliminado los espacios
        return CadenaSinBlancos.length()==0;
    }

    public static boolean esVacio(String x) {
        boolean r= false;
        int lo= x.length();
        if (lo==0){
            r=true;    

        }

        return r;
    }
 
    public static String validarDato(String x){
    String r="";
    if(esVacio(x))
       r= "DIGITE ALGO NO PUEDE SER VACIO";
    if(!esEntero(x))
        r= r + "\nDIGITE UN ENTERO \n";
    return r;
    }
    public static  boolean sonsoloLetras(String x){
        boolean r=true;
        char[] alfamin = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                          'o','p','q','r','s','t','v','w','y', 'z',' '};
        char[] alfamay = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                          'O','P','Q','R','S','T','V','W','Y', 'Z',' '};

        int n=alfamin.length;
        int nro= x.length();
         for (int i = 0; i < nro; i++) {
             char c = x.charAt(i);
            if (!estaCar(c,alfamin))
                if (!estaCar(c,alfamay))
                  r= false;
             }
        return r;  
    }
    public static boolean   estaCar(char c,char[] alfabeto){
        boolean r=false;
        for (int i = 0; i < alfabeto.length; i++) {
            if(c==alfabeto[i]){
                r=true;
                break;
            }
        }
        return r;
    }
    public static boolean tieneSoloLetras(String x){          
        Pattern p =  Pattern.compile ( "[a-zA-Z ]{1,254}" ); //. r
        Matcher m = p.matcher ( x );  
        boolean   b = m.matches ();
        return b;
    }
    public static boolean tieneSoloNros(String x){          
        Pattern p =  Pattern.compile ( "[0-9]{1,254}" ); //. r
        Matcher m = p.matcher ( x );  
        boolean   b = m.matches ();
        return b;
    }
    public static boolean tieneSoloEspacios(String x){          
        Pattern p =  Pattern.compile ( "[ ]{1,254}" ); //. r
        Matcher m = p.matcher ( x );  
        boolean   b = m.matches ();
        return b;
    }  
    public static boolean esEmailvalido(String email){
        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";

        // Lo siguiente devuelve true or flase
        return Pattern.matches(emailRegexp, email);
    }
}

