package Client.Vistas.Listas;

import Common.Dataobjects.Carrera;

import java.util.ArrayList;
import Utilerias.Table;


public class ListaCarreras{    

    Table carreras = new Table("carreras.dat");

    public void imprimirCarreras(){

        for(int i=0; i<this.carreras.size(); i++){
            Object carre = carreras.get(i);
            Carrera prueba = (Carrera)carre;
            System.out.println(prueba.getTodo());
        }
        
    } 
    
}