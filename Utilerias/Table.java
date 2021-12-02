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
                objeto = (Object)ois.readObject();
                if(objeto==null) 
                    break;
                count++;
            }
            ois.close();
            file.close();
        } catch (Exception e) {
            //TODO: handle exception
        }      
        return user;
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
    