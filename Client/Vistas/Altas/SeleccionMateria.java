package Client.Vistas.Altas;

import java.util.Scanner;
import Common.Dataobjects.HorarioMaestro;

public class SeleccionMateria{

    String materia,nombreM;
    private HorarioMaestro horarioMaestro;

    public String getNombreMateria(){
        return this.materia;
    }
    public HorarioMaestro  getHorario(){
        return this.horarioMaestro;
    }


    public SeleccionMateria(Scanner sc,String nombreM){
    
       
        this.nombreM = nombreM; 
         
        System.out.print("Nombre Materia: ");        
        materia = sc.nextLine();
        materia = sc.nextLine(); 
        this.horarioMaestro = new HorarioMaestro(nombreM,materia);

        
    }
    public void setMsg(String msg){
        System.out.println(msg);
     }
}
