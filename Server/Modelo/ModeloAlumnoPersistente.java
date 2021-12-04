package Server.Modelo;

import java.util.ArrayList;

import Common.Modelo.ModeloAlumno;

import Utilerias.Table;
import Common.Dataobjects.Alumno;

public class ModeloAlumnoPersistente implements ModeloAlumno{

    
    Table alumnos = new Table("alumnos.dat");

    public ModeloAlumnoPersistente(){
    
        /*alumnos.add(new Alumno("Gabriel Macedo","gabrielalu","1234",1,7,"8342099019","gabrielalu@hotmail.com"));
        alumnos.add(new Alumno("Eduardo Velez","eduardoalu","1234",2,7,"8342688724","eduardoalu@hotmail.com"));
        alumnos.add(new Alumno("Jaime Ramirez","jaimealu","1234",3,6,"8342212140","jaimealu@hotmail.com"));
        alumnos.add(new Alumno("Chavira","chaviraalu","1234",4,6,"8342665150","chaviraalu@hotmail.com"));
        alumnos.add(new Alumno("Grimaldo","grimialu","1234",5,3,"8343508028","grimialu@hotmail.com"));*/
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