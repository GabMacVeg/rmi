package Utilerias;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import Common.Dataobjects.Administrador;
import Common.Dataobjects.Alumno;
import Common.Dataobjects.Carrera;
import Common.Dataobjects.HorarioAlumno;
import Common.Dataobjects.HorarioMaestro;
import Common.Dataobjects.Maestro;
import Common.Dataobjects.Materia;

public class Table{

    String tableName;    

    public Table(String name){
        this.tableName = name;        
    }

    public void add(Object objeto){
        try {
            FileInputStream file = null;
            boolean existe = true;
            try{
                file = new FileInputStream(tableName);
                file.close();
            }catch(FileNotFoundException e){
                existe = false;            
            }        
            FileOutputStream fileo = new FileOutputStream(tableName, true);
            ObjectOutputStream oos;
            if(existe)
                oos = new AppendObjectOutputStream(fileo);
            else
                oos = new ObjectOutputStream(fileo);
            oos.writeObject(objeto);  
            oos.close(); 
            fileo.close();     
        } catch (Exception e) {
            //TODO: handle exception
        }       
    }

    public Object get(int index){
        Object objeto = null;
        try {            
            FileInputStream file = null;
            ObjectInputStream ois = null;
            file = new FileInputStream(tableName);
            ois = new ObjectInputStream(file);
            int count = 0;
            while(count<=index){
                objeto = ois.readObject();
                if(objeto==null) 
                    break;
                count++;
            }
            ois.close();
            file.close();
        } catch (Exception e) {
            //TODO: handle exception
        }      
        return objeto;
    }

    public int size(){
        int count = 0;
        try {
            FileInputStream file = null;
            ObjectInputStream ois = null;
            file = new FileInputStream(tableName);
            ois = new ObjectInputStream(file);            
            while(ois.readObject()!=null){            
                count++;
            }
            ois.close();
            file.close();   
        } catch (Exception e) {
            //TODO: handle exception
        } 
        return count;
    }
 public static void main(String[] args) throws IOException, ClassNotFoundException{
        Table administradores = new Table("administradores.dat");

        //administradores.add(new Administrador("Gabriel Macedo","gabriela","1234",1,"8342099019","gabriela@hotmail.com"));
        //administradores.add(new Administrador("Eduardo Velez","eduardoa","1234",2,"8342688724","eduardoa@hotmail.com"));
        //administradores.add(new Administrador("Jaime Ramirez","jaimea","1234",3,"8342212140","jaimea@hotmail.com"));


        Object admin = administradores.get(2);
        Administrador administrador=(Administrador)admin;
        System.out.println(administrador.getNombre());
        
        /*Usuario user = usuarios.get(1);
        System.out.println(user.getNombre());*/
    }
}


    
   