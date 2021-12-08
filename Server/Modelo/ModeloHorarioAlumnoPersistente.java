package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.HorarioAlumno;
import Common.Modelo.ModeloHorarioAlumno;
import Utilerias.Table;

public class ModeloHorarioAlumnoPersistente implements ModeloHorarioAlumno{

    Table horarioAlumnos = new Table("horarioAlumnos.dat");
    Table temporal = new Table("temporal.dat");
    int contador=0;
    public int identificador;
    //private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    // public ArrayList<Carrera> getCarreras(){
    //     return this.carreras;
    // }

    public ModeloHorarioAlumnoPersistente(){
        //primer usuario horarioA
        //pertece al alumno con el id 1      alumno             materia       maestro        calif
       /*horarioAlumno.add(new HorarioAlumno("Gabriel Macedo","Programacion","Alan Diaz",0));
        horarioAlumno.add(new HorarioAlumno("Eduardo Velez","Programacion","Gabriel Maestro",0));
        horarioAlumno.add(new HorarioAlumno("Gabriel Macedo","Ingles","Gabriel Maestro",0));
        horarioAlumno.add(new HorarioAlumno("Chavira","Matematicas","Eduardo Maestro",0));        
        horarioAlumno.add(new HorarioAlumno("Eduardo Velez","Quimica","Eduardo Maestro",0)); 
        horarioAlumno.add(new HorarioAlumno("Grimaldo","Contabilidad","Mirna Meza",0)); */  
    }

    public int getIdentificador(){
        return this.identificador;
    }

    public void alta(HorarioAlumno horarioAlumno){
        this.horarioAlumnos.add(horarioAlumno);
    }

    public boolean buscarMateria(String nombre,String nombreA){
        for(int i=0; i<this.horarioAlumnos.size(); i++){
            Object halu = horarioAlumnos.get(i);
            HorarioAlumno halumno=(HorarioAlumno)halu;
            if(halumno.getMateria().equals(nombre) && halumno.getnombreAlumno().equals(nombreA)){
                identificador=i;
                return true;
            }
        }
        return false;
    }


   

    public boolean buscarMateriaC(String materia,String alumno, float calif){


        for(int i=0; i<this.horarioAlumnos.size(); i++){
            Object halu = horarioAlumnos.get(i);
            HorarioAlumno horarioA=(HorarioAlumno)halu;

            if(horarioA.getMateria().equals(materia) && horarioA.getnombreAlumno().equals(alumno)){
                horarioA.setCalificacion(calif);
                contador=i;
                this.temporal.add(horarioA);
            }else{
                
            }

        }
        
        for(int i=0; i<this.horarioAlumnos.size(); i++){
            Object halu = horarioAlumnos.get(i);
            HorarioAlumno horarioA=(HorarioAlumno)halu;
            if(i!=contador){
                this.temporal.add(horarioA);
            }
        }
        this.horarioAlumnos.eliminar();

        for(int i=0; i<this.temporal.size(); i++){
            Object halu = temporal.get(i);
            HorarioAlumno horarioA=(HorarioAlumno)halu;
            this.horarioAlumnos.add(horarioA);
        }
        this.temporal.eliminar();

        return true;
    }

    

}