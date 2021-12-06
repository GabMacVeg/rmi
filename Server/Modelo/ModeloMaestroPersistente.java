package Server.Modelo;

import java.util.ArrayList;
import Utilerias.Table;

import Common.Dataobjects.Maestro;
import Common.Modelo.ModeloMaestro;


public class ModeloMaestroPersistente implements ModeloMaestro{

    //private ArrayList<Maestro> maestros = new ArrayList<Maestro>();

    /*public ArrayList<Maestro> getMaestros(){
        return this.maestros;
    }*/

    Table maestros = new Table("maestros.dat");
    int identificador=0;
    Table temporal = new Table("temporal.dat");

    public ModeloMaestroPersistente(){
        //primer usuario maestros
        /*maestros.add(new Maestro("Gabriel Maestro","gabrielm","1234",1,"8342099019","gabrielm@hotmail.com"));
        maestros.add(new Maestro("Eduardo Maestro","eduardom","1234",2,"8342688724","eduardom@hotmail.com"));
        maestros.add(new Maestro("Jaime Maestro","jaimem","1234",3,"8342212140","jaimem@hotmail.com"));
        maestros.add(new Maestro("Paco Maestro","paco","1234",4,"8342508028","grimim@hotmail.com"));
        maestros.add(new Maestro("Alan Diaz ","alan","1234",5,"8341262077","calix35@hotmail.com"));
        maestros.add(new Maestro("Mirna Meza","mirna","1234",6,"8340696969","mirna@hotmail.com"));*/
    }

    public Maestro login(String user, String pass){
        for(int i=0;i<maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(maestro.getUser().equals(user)){
                if(maestro.getPass().equals(pass)){
                    return maestro;
                }
                
            }
        }
        return null;
    }
    

    public void alta(Maestro maestro){
        this.maestros.add(maestro);
    }

    public boolean buscarMaestro(String user){
        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(maestro.getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

    public String buscarNombre(String user){
        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(maestro.getUser().equals(user)){
                return maestro.getNombre();
            }
        }
        return "Nada";
    }
    
    public int buscarMatricula(String user){
        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(maestro.getUser().equals(user)){
                return maestro.getMatricula();
            }
        }
        return 1;
    }

    public void eliminar(String user){
        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(maestro.getUser().equals(user)){
                identificador=i;
            }
        }

        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro maestro=(Maestro)mae;
            if(i!=identificador){
                this.temporal.add(maestro);
            }
        }
        this.maestros.eliminar();

        for(int i=0; i<this.temporal.size(); i++){
            Object mae = temporal.get(i);
            Maestro maestro=(Maestro)mae;
            this.maestros.add(maestro);
        }
        this.temporal.eliminar();
    }

    public void setMsg(String msg){
        System.out.println(msg);
     }

}