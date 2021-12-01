package Server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import Server.Modelo.ModeloAdministradorPersistente;
import Server.Modelo.ModeloAlumnoPersitente;
import Server.Modelo.ModeloMaestroPersitente;

import Common.Modelo.ModeloAdministrador;
import Common.Modelo.ModeloAlumno;
import Common.Modelo.ModeloMaestro;

//Interface de mi objeto remoto

public class Server {
    

    public static void main(String[] args) {
        try {
            //Creo el objeto remoto
            ModeloAdministradorPersistente modeloAd =  new ModeloAdministradorPersistente();
            ModeloAlumnoPersitente modeloAl =  new ModeloAlumnoPersitente();
            ModeloMaestroPersistente modeloMa = new ModeloMaestroPersistente();

            //Creo el stub, encargado de recibir parametros y de regresar informacion
            ModeloAdministrador modelo =  (ModeloAdministrador) UnicastRemoteObject.exportObject(modeloAd, 0);
            ModeloAlumno modelo2 =  (ModeloAlumnoA)UnicastRemoteObject.exportObject(modeloAl, 0);
            ModeloMaestro modelo3 = (ModeloMaestro)UnicastRemoteObject.exportObject(modeloMa, 0);

            //Localizar el rmiregistry, es decir que este abierto
            Registry registry = LocateRegistry.getRegistry();
            
            //Registrar el objeto en la red
            registry.rebind("ModeloAdministrador", modelo);
            registry.rebind("ModeloAlumno", modelo2);
            registry.rebind("ModeloMaestro", modelo3);

            System.out.println("Servidor listo!!!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}