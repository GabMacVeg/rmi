package Client;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.util.Scanner;

import Client.Controlador.CtrlPrincipal;

public class Client{

    public static void main(String[] args) {
    
        try {
            //Localizar el rmiregistry
            //OJO: El rmiregistry solo se ejecuta en el servidor
            //Como el cliente y el servidor estan en la misma computadora, se le puede poner localhost
            
            //Scanner sc = new Scanner(System.in);
            //Obtengo el objeto remoto
            //Calculadora calculadora = (Calculadora)registry.lookup("Calculadora");
            /*do{
                new Login(sc).show();

            }while(true);*/
            new CtrlPrincipal();
            
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}