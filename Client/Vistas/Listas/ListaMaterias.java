package Client.Vistas.Listas;

import Common.Dataobjects.Materia;

import java.util.ArrayList;
import Utilerias.Table;


public class ListaMaterias{   
    private Materia materia; 

    Table materias = new Table("materias.dat");

    public void imprimirMaterias(){

        for(int i=0; i<this.materias.size(); i++){
            Object mate = materias.get(i);
            this.materia=(Materia)mate;
            materia.getTodo();
        }
        
    } 
    
}