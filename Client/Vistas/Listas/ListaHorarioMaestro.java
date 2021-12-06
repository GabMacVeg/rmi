package Client.Vistas.Listas;

import Common.Dataobjects.HorarioMaestro;
import Common.Modelo.ModeloHorarioMaestro;
import Common.Modelo.ModeloMaestro;
import Common.Dataobjects.Maestro; 

import Utilerias.Table;
import java.util.ArrayList;

public class ListaHorarioMaestro{

    public void imprimirHorario(String nombreM){

        Table horarioMaestros = new Table("horarioMaestros.dat");

        for(int i=0; i<horarioMaestros.size(); i++){
            Object maaes = horarioMaestros.get(i);
            HorarioMaestro prueba = (HorarioMaestro)maaes;
            if(prueba.getnombreMaestro().equals(nombreM)){
                System.out.println(prueba);
            }
        }
    }
}