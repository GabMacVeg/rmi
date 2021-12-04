package Common.Dataobjects;
import java.io.Serializable;

public class Materia implements Serializable{
    private String nombre;
    private int matricula;
    private int semestre;

    public String getNombre(){
        return this.nombre;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public int getSemestre(){
        return this.semestre;
    }
    
    public Materia (String nombre, int matricula, int semestre){
        this.nombre = nombre;
        this.matricula = matricula;
        this.semestre = semestre;
    }
    
    public String getTodo(){
        return this.nombre + "\t" + this.matricula + "\t" + this.semestre;
    }


}