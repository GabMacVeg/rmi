package Client.Vistas.Listas;

import Common.Dataobjects.Maestro;
import Utilerias.Table;
import java.util.ArrayList;

public class VerDatosM{   

    Table maestros = new Table("maestros.dat"); 

    public void imprimirDatosM(String nombreM){
        for(int i=0; i<maestros.size(); i++){
            Object mae = maestros.get(i);
            Maestro prueba = (Maestro)mae;
            if(prueba.getNombre().equals(nombreM)){
                //System.out.println(maestros.get(i).getNombre()+"\t"+maestros.get(i).getUser()+"\t"+maestros.get(i).getMatricula()+"\t"+maestros.get(i).getNTelefonico()+"\t"+maestros.get(i).getCorreo());
                System.out.println(prueba.getDatos());
            }
        }
    } 
    
}