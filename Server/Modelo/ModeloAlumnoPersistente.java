package Server.Modelo;

import java.util.ArrayList;

import Common.Modelo.ModeloAlumno;

import Utilerias.Table;
import Common.Dataobjects.Alumno;

public class ModeloAlumnoPersistente implements ModeloAlumno{

    
    Table alumnos = new Table("alumnos.dat");

    public ModeloAlumnoPersistente(){
    
        //alumnos.add(new Usuario("alan","1234","Alan Diaz", 1));

    }

    public Alumno login(String user, String pass){  
        //metodo size, darme el numero de elementos de la lista
        for(int i=0;i<alumnos.size();i++){//Recorriendo la lista
            Object alum = alumnos.get(i);
            Alumno alumno=(Alumno)alum;
            //El metodo get, me da el elemento que esta en la posicion i de la lista
            if(alumno.getUser().equals(user) && alumno.getPass().equals(pass)){
                return (Alumno)alumnos.get(i);
            }
        }
        return null;
    }

    public void alta(Alumno alumno){
        this.alumnos.add(alumno);
    }

    public boolean buscarAlumno(String user){
        for(int i=0; i<this.alumnos.size(); i++){
            Object alum = alumnos.get(i);
            Alumno alumno=(Alumno)alum;
            if(
                alumno.getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

}