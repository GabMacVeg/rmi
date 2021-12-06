package Client.Vistas.Listas;

import Common.Dataobjects.Administrador;
import Utilerias.Table;
import java.util.ArrayList;

public class VerDatosAdmin{    

    Table administradores = new Table("administradores.dat");

    public void imprimirDatosAdmin(String nombreAd){
        for(int i=0; i<administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador prueba = (Administrador)admin;
            if(prueba.getNombre().equals(nombreAd)){
                //return administradores.get(i).getNombre()+"\t"+administradores.get(i).getUser()+"\t"+administradores.get(i).getMatricula()+"\t"+administradores.get(i).getNTelefonico()+"\t"+administradores.get(i).getCorreo();
                System.out.println(prueba.getDatos());
            }
        }
    } 
    
}