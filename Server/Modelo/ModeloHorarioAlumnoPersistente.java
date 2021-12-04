package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.HorarioAlumno;
import Common.Modelo.ModeloHorarioAlumno;
import Utilerias.Table;

public class ModeloHorarioAlumnoPersistente implements ModeloHorarioAlumno{

    Table horarioAlumno = new Table("horarioalumno.dat");

    //private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    // public ArrayList<Carrera> getCarreras(){
    //     return this.carreras;
    // }

    public ModeloHorarioAlumnoPersistente(){
        //primer usuario administrador
        //horarioAlumno.add(new HorarioAlumno("Gabriel Macedo","Programacion","Alan Diaz",0));
        
    }

    public void alta(HorarioAlumno horarioAlumno){
        this.horarioAlumno.add(horarioAlumno);
    }

    public boolean buscarMateria(String nombre){
        for(int i=0; i<this.horarioAlumno.size(); i++){
            if(this.horarioAlumno.get(i).getMateria().equals(nombre)){
                return true;
            }
        }
        return false;
    }


   /* public void eliminar(String nombre){
        for(int i=0; i<this.carreras.size(); i++){
            if(this.carreras.get(i).getNombre().equals(nombre)){
                this.carreras.remove(i);
            }
        }
        
    }*/

    public boolean buscarMateriaC(String materia,String alumno, float calif){

        for(int i=0; i<this.horarioAlumno.size(); i++){

            if(this.horarioAlumno.get(i).getMateria().equals(materia) && this.horarioAlumno.get(i).getnombreAlumno().equals(alumno)){
                this.horarioAlumno.get(i).setCalificacion(calif);                
                return true;
            }
        }
        return false;
    }

}