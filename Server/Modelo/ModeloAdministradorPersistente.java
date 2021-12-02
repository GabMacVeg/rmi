package Server.Modelo;

import java.util.ArrayList;

import Common.ModeloUsuarios;

import Utilerias.Table;
import Common.Administrador;

public class ModeloAdministradorPersistente implements ModeloAdministrador{

    //ArrayList - Crear una lista de objetos (object, int, float, ....)

    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Table administradores = new Table("administradores.dat");

    public ModeloUsuariosPersistente(){
        //Metodo add, agregar un elemento al final de la lista
        //Administrador
        //usuarios.add(new Usuario("alan","1234","Alan Diaz", 1));
        //usuarios.add(new Usuario("ventas","ventas","ventas", 2));
    }

    public Administrador login(String user, String pass){  
        //metodo size, darme el numero de elementos de la lista
        for(int i=0;i<usuarios.size();i++){//Recorriendo la lista
            //El metodo get, me da el elemento que esta en la posicion i de la lista
            if(administradores.get(i).getUser().equals(user) && administradores.get(i).getPass().equals(pass)){
                return administradores.get(i);
            }
        }
        return null;
    }

    public void alta(Administrador administrador){
        this.administradores.add(administrador);
    }

    public boolean buscarAdmin(String user){
        for(int i=0; i<this.administradores.size(); i++){
            if(this.administradores.get(i).getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

}