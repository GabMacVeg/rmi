package Client.Vistas.Listas;

import Common.Dataobjects.Alumno;
import Utilerias.Table;
import java.util.ArrayList;

public class VerDatosA{    

    Table alumnos = new Table("alumnos.dat");

    public void imprimirDatosA(String nombreA){
        for(int i=0; i<alumnos.size(); i++){
            Object alu = alumnos.get(i);
            Alumno prueba = (Alumno)alu;
            if(prueba.getNombre().equals(nombreA)){
                //System.out.println(alumnos.get(i).getNombre()+"\t"+alumnos.get(i).getUser()+"\t"+alumnos.get(i).getMatricula()+"\t"+alumnos.get(i).getNTelefonico()+"\t"+alumnos.get(i).getCorreo());
                System.out.println(prueba.getDatos());
            }
        }
    } 
    
}