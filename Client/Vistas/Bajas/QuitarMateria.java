package Client.Vistas.Bajas;

import java.util.Scanner;


public class QuitarMateria{
    private Scanner sc;
    private String materia;

    public String getMateria(){
        return this.materia;
    }

    public QuitarMateria(Scanner sc){
        this.sc =  sc;        
    }

    public void show(){
        System.out.print("Materia: ");
        materia = sc.nextLine();
        materia = sc.nextLine();
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }

}