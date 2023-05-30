package CONTROL;
import MODELO.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Grupo {
    
    private String materia;
    private String idGrupo;
    public ArrayList<Estudiante> estudiantes;
    public ArrayList<Nota> notas;
    private String codigoDeUsuario;
    private String password;
    

    public Grupo() {
        idGrupo = "341";
        estudiantes = new ArrayList<Estudiante>();
        notas = new ArrayList<Nota>();
    }
    
    public Grupo(String idg) {
        idGrupo = idg;
        estudiantes = new ArrayList<Estudiante>();
        notas = new ArrayList<Nota>();
    }
    
    //Gestion de estudiantes
    public boolean add(Estudiante x){
        boolean r = false;
        if (buscarxPos(x.getIdEst()) > 0) {
            r = false;
        }
        else{
            r = TransaccEst.adicionar(x);
            if (r == true) {
                estudiantes.add(x);
            }
        }
        return r;
    }
    public int buscarxPos(int idEst){
        int r = -1;
        for (Estudiante estux : estudiantes) {
            if (estux.getIdEst() == idEst) {
                r = estudiantes.indexOf(estux);
                break;
            }
        }
        return r;
    }
    public Estudiante buscar(int idEst){
        Estudiante r = null;
        for (Estudiante estux : estudiantes) {
            if (estux.getIdEst() == idEst) {
                r = estux;
                break;
            }
        }
        return r;
    }
    public boolean eliminar(int idEst){
        boolean r = false;
        r = TransaccEst.eliminar(idEst);
        if(r == true){
        for (Estudiante estux : estudiantes) {
            if (estux.getIdEst() == idEst) {
                estudiantes.remove(estux);
                r = true;
                break;
            }
        }
        }
        return r;
    }
    public boolean modificar(Estudiante x){
        boolean r = false;
        r = TransaccEst.modificar(x);
        if(r == true){
            for (Estudiante estux : estudiantes) {
                if (estux.getIdEst() == x.getIdEst()) {
                    estux.setApellido(x.getApellido());
                    estux.setNombre(x.getNombre());
                    estux.setSexo(x.getSexo());
                    estux.setEmail(x.getEmail());
                    r = true;
                    break;
                }
            }
        }
        return r;
    }
    public void llenar(){
       Estudiante a = new Estudiante(11,"Perez","Pedro",'M',"pperez@gmail.com");
       add(a);
       a = new Estudiante(12,"Ramirez","Giovanna",'F',"gramirez@gmail.com");
       add(a); 
       a = new Estudiante(15,"Paris","Natalia",'F',"nparis@gmail.com");
       add(a); 
       a = new Estudiante(17,"Pitt","Brad",'M',"pbrad@gmail.com");
       add(a);
    }
    
    public DefaultTableModel cargarDatosParaJTable(){
        DefaultTableModel mod;
        mod = new DefaultTableModel();
        Estudiante ayuda = new Estudiante();
        mod.setColumnIdentifiers(ayuda.getTitulos());
        for (Estudiante estx : estudiantes) {
            mod.addRow(estx.getDatos());
        }
        return mod;
    }
    public DefaultTableModel cargarDatosNotasParaJTable(){
        DefaultTableModel mod;
        mod = new DefaultTableModel();
        Nota ayuda = new Nota();
        mod.setColumnIdentifiers(ayuda.getTitulos());
        for (Nota notx : notas) {
            mod.addRow(notx.getDatos());
        }
        return mod;
    }
    
    /*
    
    GESTIÓN DE NOTAS    
    
    */
    
    
    public boolean addNota(Nota x){
        boolean r = false;
        if (buscarxPosNota(x.getIdNota()) > 0) {
            r = false;
        }
        else{
            r = TransaccNota.adicionar(x);
            if (r == true) {
                notas.add(x);
            }
        }
        return r;
    }
    
    public int buscarxPosNota(int idNota){
        int r = -1;
        for(Nota notax : notas){
            if (notax.getIdNota() == idNota) {
                r = notas.indexOf(notax);
                break;
            }
        }
        return r;
    }
    
    public Nota buscarNota(int idNota){
        Nota r = null;
        for(Nota notax : notas){
            if (notax.getIdNota() == idNota) {
                r = notax;
                break;
            }
        }
        return r;
    }
    
    public Nota buscarNotaEst(int idEstx){
        Nota r = null;
        for(Nota notax : notas){
            if (notax.getIdEst() == idEstx) {
                r = notax;
                break;
            }
        }
        return r;
    }
    
    public boolean eliminarNota(int idNota){
        boolean r = false;
        r = TransaccNota.eliminar(idNota);
        if (r == true) {
            for(Nota notax : notas){
                if (notax.getIdNota() == idNota) {
                    notas.remove(notax);
                    r = true;
                    break;
                }
            }
        }
        return r;
    }
    
    public boolean modificarNota(Nota x){
        boolean r = false;
        r = TransaccNota.modificar(x);
        if (r == true) {
            for(Nota notax : notas){
                if (notax.getIdNota() == x.getIdNota()) {
                    notax.setTipo(x.getTipo());
                    notax.setValor(x.getValor());
                    notax.setPorcentaje(x.getPorcentaje());
                    notax.setCorte(x.getCorte());
                    notax.setIdEst(x.getIdEst());
                    r = true;
                    break;
                }
            }
        }
        return r;
    }        
    public static void main(String[] args) {
        Grupo GR = new Grupo("341B");
        GR.llenar();
        GR.eliminar(12);
        Estudiante a = new Estudiante(11,"PEREZ","PEDRO",'M',"otroemail@gmail.com");
        GR.modificar(a);
        Estudiante m = GR.buscar(15);
        System.out.println(m);
        System.out.println(GR.estudiantes);
    }
    
   
    
}
