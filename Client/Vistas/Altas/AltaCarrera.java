
package Client.Vistas.Altas;

import java.util.Scanner;
import Common.Dataobjects.Carrera;


public class AltaCarrera{
    private Carrera carrera;

     public  Carrera getCarrera(){
        return this.carrera;
    }

    String nombre;
        int matricula;
    public String getNombre(){
        return this.nombre;
    }
    public int getMatricula(){
        return this.matricula;
    }

    public  AltaCarrera(Scanner sc){
        
        System.out.print("Nombre: ");        
        nombre = sc.nextLine();
        nombre = sc.nextLine();
        System.out.print("Matricula: ");
        matricula = sc.nextInt();
        this.carrera = new Carrera(nombre, matricula);
        
    }
    public void setMsg(String msg){
        System.out.println(msg);
     }
     
}
