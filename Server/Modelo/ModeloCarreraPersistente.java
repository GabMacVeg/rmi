package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.Carrera;
import Common.Modelo.ModeloCarrera;
import Utilerias.Table;

public class ModeloCarreraPersistente implements ModeloCarrera{

    Table carreras = new Table("carreras.dat");
    int identificador=0;
    Table temporal = new Table("temporal.dat");

    //private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    // public ArrayList<Carrera> getCarreras(){
    //     return this.carreras;
    // }

    public ModeloCarreraPersistente(){
        //primer usuario administrador
        //carreras.add(new Carrera("Programacion",2222));
        //carreras.add(new Carrera("Ingles",3333));
    }

    public void alta(Carrera carrera){
        this.carreras.add(carrera);
    }

    public boolean buscarCarrera(String nombre){
        for(int i=0; i<this.carreras.size(); i++){
            Object carre = carreras.get(i);
            Carrera carrera=(Carrera)carre;
            if(carrera.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }


   public void eliminar(String user){
        for(int i=0; i<this.carreras.size(); i++){
            Object carre = carreras.get(i);
            Carrera carrera=(Carrera)carre;
            if(carrera.getNombre().equals(user)){
                identificador=i;
            }
        }

        for(int i=0; i<this.carreras.size(); i++){
            Object carre = carreras.get(i);
            Carrera carrera=(Carrera)carre;
            if(i!=identificador){
                this.temporal.add(carrera);
            }
        }
        this.carreras.eliminar();

        for(int i=0; i<this.temporal.size(); i++){
            Object carre = temporal.get(i);
            Carrera carrera=(Carrera)carre;
            this.carreras.add(carrera);
        }
        this.temporal.eliminar();
    }

}