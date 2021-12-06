package Client.Vistas.Listas;

import Common.Dataobjects.Maestro;

import java.util.ArrayList;
import Utilerias.Table;

public class ListaMaestro{   
    
     
    Table maestros = new Table("maestros.dat");

    public void imprimirMaestros(){
        for(int i=0; i<this.maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro prueba = (Maestro)mae;
            System.out.println(prueba.getDatos());
        }
        
    } 

}