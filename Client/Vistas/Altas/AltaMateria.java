
package Client.Vistas.Altas;

import java.util.Scanner;
import Common.Dataobjects.Materia;

public class AltaMateria{
    private Materia materia;

    public  Materia getMateria(){
        return this.materia;
    }

    String nombre;
    int matricula, semestre;

    public String getNombre(){
        return this.nombre;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public int getSemestre(){
        return this.semestre;
    }

    public  AltaMateria(Scanner sc){
        
        System.out.print("Nombre: ");        
        nombre = sc.nextLine();
        nombre = sc.nextLine();
        System.out.print("Matricula: ");
        matricula = sc.nextInt();   
        System.out.println("Semestre: ");        
        semestre = sc.nextInt();
        this.materia = new Materia(nombre, matricula, semestre);
        
    }
    public void setMsg(String msg){
        System.out.println(msg);
     }
}
