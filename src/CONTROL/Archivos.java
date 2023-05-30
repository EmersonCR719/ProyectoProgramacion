package CONTROL;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import javax.swing.JFileChooser;
 
@SuppressWarnings("all")
 
 
 

public class Archivos {
    
public static  boolean validarCrearDirectorio(){
    boolean r=true;
    String dir="c:/temp/imagenes";
     File directorio = new File(dir);
    if (!directorio.exists()) {
        directorio.mkdirs();
         
        r=true;
    }
    return r;
}
public static  boolean validarBorrarArchivo(){
    boolean r=false;
    String arch="c:/temp/imagenes";
     File directorio = new File(arch);
    if (directorio.exists()) {
        r=directorio.delete();
   
    }
    return r;
}
public static  boolean validarBorrarArchivo(String archrOrigen){
    boolean r=false;
    String arch=archrOrigen;
     File directorio = new File(arch);
    if (directorio.exists()) {
        r=directorio.delete();
   
    }
    return r;
}
public static  boolean validarCrearDirectorio(String destino){
    boolean r=true;
    String dir=destino;
     File directorio = new File(dir);
    if (!directorio.exists()) {
        directorio.mkdirs();
        r=true;
    }
    return r;
}
 public static void borrarDirectorio(String  directorio) {
        try {
            
        
        java.nio.file.Path dir = Paths.get(directorio); //path to the directory  
        Files
            .walk(dir) // Traverse the file tree in depth-first order
            .sorted(Comparator.reverseOrder())
            .forEach(path -> {
                try {
                    System.out.println("Deleting: " + path);
                    Files.delete(path);  //delete each file or directory
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
        }
    }
 
public static  boolean validarSiexisteDirectorio(String dir){
    boolean r=false;
 //  private void comprobarCrearDirectorio(String ruta) {
    File directorio = new File(dir);
    if (directorio.exists()) {
       
        r=true;
    }
     
 
    return r;
}
public static  boolean validarSiexisteArhivo(String narchivo){
    boolean r=false;
    File arch = new File(narchivo);
    if (arch.exists()) {
       
        r=true;
    }
    
    return r;
}
public static  String seleccionarArchivo(){
    String  r="";
    JFileChooser fc = new JFileChooser();
//Mostrar la ventana para abrir archivo y recoger la respuesta
//En el parámetro del showOpenDialog se indica la ventana
//  al que estará asociado. Con el valor this se asocia a la
//  ventana que la abre.
int respuesta = fc.showOpenDialog(null);
//Comprobar si se ha pulsado Aceptar
if (respuesta == JFileChooser.APPROVE_OPTION) {
    //Crear un objeto File con el archivo elegido
    File archivoElegido = fc.getSelectedFile();
    //Mostrar el nombre del archvivo en un campo de texto
    r=archivoElegido.getName();
    
}
    
    return r;
}
public boolean seleccionarMoverArchivo(String dir){
    boolean r=true;
    String nombreS=seleccionarArchivo();
   // mover
    
     return r;
}
public static void moveFile(String archOrigen, String arhcDestino) {
    File fromSrc = new File(archOrigen);
     File toDestino = new File(arhcDestino);
    try {
       Files.move(fromSrc.toPath(),  toDestino.toPath(), StandardCopyOption.REPLACE_EXISTING); 
    } catch (IOException e) {
        System.out.println(e);
        
    }
}
 
public static  boolean pasarDirectorio(String dirOrigen, String dirDestino){
    boolean r=true;
    validarCrearDirectorio(dirDestino);
    File directorio = new File(dirOrigen);
    File f;
    String destino=dirDestino;
    if (directorio.isDirectory()) {
         validarCrearDirectorio(destino);
        String [] files = directorio.list();
        if (files.length > 0) {
            for (String archivo : files) {
                f = new File (dirOrigen + File.separator + archivo);
                if(f.isDirectory()) {
                    validarCrearDirectorio(destino+File.separator+archivo+File.separator);
                     pasarDirectorio(dirOrigen+File.separator+archivo+File.separator, destino+File.separator+archivo+File.separator);
                } else { //Es un archivo
                    copiarArchivo(dirOrigen+File.separator+archivo, destino+File.separator+archivo);
                }
            }
        }
        else
            r=false;
    } 
    else
        r=false;
 
   
    return r;
}
public  static void copiarArchivo(String sOrigen, String sDestino) {
    try {
        File origen = new File(sOrigen);
        File destino = new File(sDestino);
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);

        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public boolean copiarFile(String archyDirOrigen, String carpetaDstino){
    boolean r=false;
    Path sourceFile = Paths.get(archyDirOrigen);
    String targetdiryArch=carpetaDstino+archyDirOrigen;
    //"e:\\Java\\JavaSE\\NIO\\NioVideo.mp4"
    Path targetFile = Paths.get( targetdiryArch);
 
try {
 
    Files.copy(sourceFile, targetFile,
        StandardCopyOption.REPLACE_EXISTING);
       r=true;
 
} catch (IOException ex) {
    System.err.format("I/O Error when copying file \n"+ex);
}
return r;
}
public static void main(String[] args) {
 if( validarCrearDirectorio()){     
     System.out.println("ya existe se creo  o ya estaba");       
   } 
if(validarSiexisteDirectorio("c:/temp/imagenes")) { 
    System.out.println("SI EXISTE"); 
   }

if(pasarDirectorio("c:/temp/imagenes2","c:/temp/imagenes")){
    System.out.println("SE PASO TODO");
}
    borrarDirectorio("c:/temp/imagenes2");
  
     
}
}


