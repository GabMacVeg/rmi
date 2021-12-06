package Server.Modelo;

import java.util.ArrayList;

import Common.Modelo.ModeloAdministrador;

import Utilerias.Table;
import Common.Dataobjects.Administrador;

public class ModeloAdministradorPersistente implements ModeloAdministrador{

    int identificador=0;

    //ArrayList - Crear una lista de objetos (object, int, float, ....)

    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Table administradores = new Table("administradores.dat");
    Table temporal = new Table("temporal.dat");

    public ModeloAdministradorPersistente(){
        
        /*administradores.add(new Administrador("Gabriel Macedo","gabriela","1234",1,"8342099019","gabriela@hotmail.com"));
        administradores.add(new Administrador("Eduardo Velez","eduardoa","1234",2,"8342688724","eduardoa@hotmail.com"));
        administradores.add(new Administrador("Jaime Ramirez","jaimea","1234",3,"8342212140","jaimea@hotmail.com"));*/

    }

    public Administrador login(String user, String pass){  
        //metodo size, darme el numero de elementos de la lista
        for(int i=0;i<administradores.size();i++){//Recorriendo la lista
            Object admin = administradores.get(i);
            Administrador administrador=(Administrador)admin;
            //El metodo get, me da el elemento que esta en la posicion i de la lista
            if (administrador.getUser().equals(user) && administrador.getPass().equals(pass)){
                return (Administrador)administradores.get(i);
            }
        }
        return null;
    }

    public void alta(Administrador administrador){
        this.administradores.add(administrador);
    }

    public boolean buscarAdmin(String user){
        for(int i=0; i<this.administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador administrador=(Administrador)admin;
            if(administrador.getUser().equals(user)){
                return true;
            }
        }
        return false;
    }
    public String buscarNombre(String user){
        for(int i=0; i<this.administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador administrador=(Administrador)admin;
            if(administrador.getUser().equals(user)){
                return administrador.getNombre();
            }
        }
        return "false";
    }

    public void eliminar(String user){
        for(int i=0; i<this.administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador administrador=(Administrador)admin;
            if(administrador.getUser().equals(user)){
                identificador=i;
            }
        }

        for(int i=0; i<this.administradores.size(); i++){
            Object admin = administradores.get(i);
            Administrador administrador=(Administrador)admin;
            if(i!=identificador){
                this.temporal.add(administrador);
            }
        }
        this.administradores.eliminar();

        for(int i=0; i<this.temporal.size(); i++){
            Object admin = temporal.get(i);
            Administrador administrador=(Administrador)admin;
            this.administradores.add(administrador);
        }
        this.temporal.eliminar();
    }
       
}