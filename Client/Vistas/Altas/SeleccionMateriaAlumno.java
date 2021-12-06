package Client.Vistas.Altas;

import java.util.Scanner;
import Common.Dataobjects.HorarioAlumno;

public class SeleccionMateriaAlumno{

    String materia,nombreProfe,nombreA;
    private HorarioAlumno horarioAlumno;

    public String getNombreProfe(){
        return this.nombreProfe;
    }
    public String getMateria(){
        return this.materia;
    }
    public HorarioAlumno getHorario(){
        return this.horarioAlumno;
    }


    public SeleccionMateriaAlumno(Scanner sc,String nombreA){
        this.nombreA = nombreA;
        System.out.print("Nombre Materia: ");        
        materia = sc.nextLine();
        materia = sc.nextLine(); 
        System.out.println("Nombre Profesor: ");
        nombreProfe = sc.nextLine();
        this.horarioAlumno = new HorarioAlumno(nombreA,materia,nombreProfe,0);
        
    }
    public void setMsg(String msg){
        System.out.println(msg);
     }
}
