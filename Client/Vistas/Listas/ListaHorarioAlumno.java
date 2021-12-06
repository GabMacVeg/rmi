package Client.Vistas.Listas;

import Common.Dataobjects.HorarioAlumno;
import Common.Modelo.ModeloHorarioAlumno;
import Common.Modelo.ModeloAlumno;
import Common.Dataobjects.Alumno; 
import Utilerias.Table;

import java.util.ArrayList;

public class ListaHorarioAlumno{

    Table horarioAlumnos = new Table("horarioAlumnos.dat");

    public void imprimirHorario(String nombreA){

        for(int i=0; i<horarioAlumnos.size(); i++){
            Object alu = horarioAlumnos.get(i);
            HorarioAlumno prueba = (HorarioAlumno)alu;
            if(prueba.getnombreAlumno().equals(nombreA)){
                System.out.println(prueba);
            }
        }
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

    public void imprimirHorarioMateria(String nombre){

        for(int i=0; i<horarioAlumnos.size(); i++){
            Object alu = horarioAlumnos.get(i);
            HorarioAlumno prueba = (HorarioAlumno)alu;
            if(prueba.getMateria().equals(nombre)){
                //System.out.println(horarioAlumno.get(i).getnombreAlumno()+ "\t" +horarioAlumno.get(i).getMateria());
                System.out.println(prueba.getDatos());
            }
        }

    }

}