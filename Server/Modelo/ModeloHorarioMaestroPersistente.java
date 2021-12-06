package Server.Modelo;

import java.util.ArrayList;

import Common.Dataobjects.HorarioMaestro;
import Common.Modelo.ModeloHorarioMaestro;
import Utilerias.Table;

public class ModeloHorarioMaestroPersistente implements ModeloHorarioMaestro{

    Table horarioMaestros = new Table("horarioMaestros.dat");

    //private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    // public ArrayList<Carrera> getCarreras(){
    //     return this.carreras;
    // }

    public ModeloHorarioMaestroPersistente(){
        //primer usuario administrador
        /*horarioMaestro.add(new HorarioMaestro("Gabriel Maestro","Programacion"));
        horarioMaestro.add(new HorarioMaestro("Gabriel Maestro","Ingles"));
        horarioMaestro.add(new HorarioMaestro("Eduardo Maestro","Quimica"));
        horarioMaestro.add(new HorarioMaestro("Eduardo Maestro","Matematicas"));
        horarioMaestro.add(new HorarioMaestro("Jaime Maestro","nada"));
        horarioMaestro.add(new HorarioMaestro("Paco Maestro","nada"));
        horarioMaestro.add(new HorarioMaestro("Alan Diaz","Programacion"));
        horarioMaestro.add(new HorarioMaestro("Mirna Meza","Contabilidad"));*/
    }

    public void alta(HorarioMaestro horarioMaestro){
        this.horarioMaestros.add(horarioMaestro);
    }

    public boolean buscarMateria(String nombre){
        for(int i=0; i<this.horarioMaestros.size(); i++){
            Object hmae = horarioMaestros.get(i);
            HorarioMaestro horarioM = (HorarioMaestro)hmae;
            if(horarioM.getMateria().equals(nombre)){
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