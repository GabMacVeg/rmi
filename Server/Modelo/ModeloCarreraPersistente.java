package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.Carrera;
import Common.Modelo.ModeloCarrera;
import Utilerias.Table;

public class ModeloCarreraPersistente implements ModeloCarrera{

    Table carreras = new Table("carreras.dat");

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
            if(this.carreras.get(i).getNombre().equals(nombre)){
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

}