package Client.Vistas.Listas;

import Common.Dataobjects.Alumno;

import java.util.ArrayList;
import Utilerias.Table;

public class ListaAlumno{    


    Table alumnos = new Table("alumnos.dat");

    public void imprimirAlumnos(){
        for(int i=0; i<this.alumnos.size(); i++){
            Object alumno = alumnos.get(i);
            System.out.println(alumno);
        }
        
    } 

}