package Client.Vistas.Listas;

import Common.Dataobjects.Administrador;

import java.util.ArrayList;
import Utilerias.Table;


public class ListaAdministrador{    

    Table administradores = new Table("administradores.dat");

    public void imprimirAdministradores(){

        for(int i=0; i<this.administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador prueba = (Administrador)admin;
            System.out.println(prueba.getDatos());
        }
        
    } 
    
}