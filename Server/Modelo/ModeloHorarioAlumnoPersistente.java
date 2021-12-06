package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.HorarioAlumno;
import Common.Modelo.ModeloHorarioAlumno;
import Utilerias.Table;

public class ModeloHorarioAlumnoPersistente implements ModeloHorarioAlumno{

    Table horarioAlumnos = new Table("horarioAlumnos.dat");

    //private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    // public ArrayList<Carrera> getCarreras(){
    //     return this.carreras;
    // }

    public ModeloHorarioAlumnoPersistente(){
        //primer usuario administrador
        //pertece al alumno con el id 1      alumno             materia       maestro        calif
       /*horarioAlumno.add(new HorarioAlumno("Gabriel Macedo","Programacion","Alan Diaz",0));
        horarioAlumno.add(new HorarioAlumno("Eduardo Velez","Programacion","Gabriel Maestro",0));
        horarioAlumno.add(new HorarioAlumno("Gabriel Macedo","Ingles","Gabriel Maestro",0));
        horarioAlumno.add(new HorarioAlumno("Chavira","Matematicas","Eduardo Maestro",0));        
        horarioAlumno.add(new HorarioAlumno("Eduardo Velez","Quimica","Eduardo Maestro",0)); 
        horarioAlumno.add(new HorarioAlumno("Grimaldo","Contabilidad","Mirna Meza",0)); */  
    }

    public void alta(HorarioAlumno horarioAlumno){
        this.horarioAlumnos.add(horarioAlumno);
    }

    public boolean buscarMateria(String nombre){
        for(int i=0; i<this.horarioAlumnos.size(); i++){
            Object halu = horarioAlumnos.get(i);
            HorarioAlumno halumno=(HorarioAlumno)halu;
            if(halumno.getMateria().equals(nombre)){
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

        for(int i=0; i<this.horarioAlumnos.size(); i++){

            Object halu = horarioAlumnos.get(i);
            HorarioAlumno halumno=(HorarioAlumno)halu;

            if(halumno.getMateria().equals(materia) && halumno.getnombreAlumno().equals(alumno)){
                halumno.setCalificacion(calif);                
                return true;
            }
        }
        return false;
    }

}