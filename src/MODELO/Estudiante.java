package MODELO;

public class Estudiante {
    private int idEst;
    private String apellido;
    private String nombre;
    private char sexo;
    private String email;
    private String dirRuta;
    private String foto;
    
    //Metodos
    public Estudiante() {
        this.idEst = 0;
        this.apellido = "";
        this.nombre = "";
        this.sexo = ' ';
        this.email = "";
        this.dirRuta = "";
        this.foto = "";
    }
    
    public Estudiante(int idEst, String apellido, String nombre, char sexo, String email) {
        this.idEst = idEst;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sexo = sexo;
        this.email = email;
    }

    public Estudiante(int idEst, String apellido, String nombre, char sexo, String email, String dirRuta, String foto) {
        this.idEst = idEst;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sexo = sexo;
        this.email = email;
        this.dirRuta = dirRuta;
        this.foto = foto;
    }
    
    
    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDirRuta(){
        return dirRuta;
    }
    
    public void setDirRuta(String dirRuta){
        this.dirRuta = dirRuta;
    }
    
    public String getFoto(){
        return foto;
    }
    
    public void setFoto(String foto){
        this.foto = foto;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + "idEst=" + idEst + ", apellido=" + apellido + 
                ", nombre=" + nombre + ", sexo=" + sexo +
                ", email=" + email +", dirRuta = "+dirRuta+", foto = " +foto+ "}\n";
    }
    //Datos que se muestran en el jtable:
    //Columnas
    public String[] getTitulos(){
        String r[] = {"idEst","apellido","nombre","sexo","email","dirRuta","foto"};
        return r;      
    }
    //Filas
    public String[] getDatos(){
        String r[] = {Integer.toString(idEst),apellido,nombre,Character.toString(sexo),email,dirRuta,foto};
        return r;      
    }
}
