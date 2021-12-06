package Server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import Server.Modelo.ModeloAdministradorPersistente;
import Server.Modelo.ModeloAlumnoPersistente;
import Server.Modelo.ModeloMaestroPersistente;
import Server.Modelo.ModeloCarreraPersistente;
import Server.Modelo.ModeloHorarioAlumnoPersistente;
import Server.Modelo.ModeloHorarioMaestroPersistente;
import Server.Modelo.ModeloMateriaPersistente;


import Common.Modelo.ModeloAdministrador;
import Common.Modelo.ModeloAlumno;
import Common.Modelo.ModeloMaestro;
import Common.Modelo.ModeloCarrera;
import Common.Modelo.ModeloHorarioAlumno;
import Common.Modelo.ModeloHorarioMaestro;
import Common.Modelo.ModeloMateria;

//Interface de mi objeto remoto

public class Server {
    

    public static void main(String[] args) {
        try {
            //Creo el objeto remoto
            ModeloAdministradorPersistente modeloAd =  new ModeloAdministradorPersistente();
            ModeloAlumnoPersistente modeloAl =  new ModeloAlumnoPersistente();
            ModeloMaestroPersistente modeloMa = new ModeloMaestroPersistente();
            ModeloCarreraPersistente modeloCa = new ModeloCarreraPersistente();
            ModeloHorarioAlumnoPersistente modeloha = new ModeloHorarioAlumnoPersistente();
            ModeloHorarioMaestroPersistente modelohma = new ModeloHorarioMaestroPersistente();
            ModeloMateriaPersistente modeloMat = new ModeloMateriaPersistente();

            //Creo el stub, encargado de recibir parametros y de regresar informacion
            ModeloAdministrador modelo =  (ModeloAdministrador) UnicastRemoteObject.exportObject(modeloAd, 0);
            ModeloAlumno modelo2 =  (ModeloAlumno)UnicastRemoteObject.exportObject(modeloAl, 0);
            ModeloMaestro modelo3 = (ModeloMaestro)UnicastRemoteObject.exportObject(modeloMa, 0);
            ModeloCarrera modelo4 = (ModeloCarrera)UnicastRemoteObject.exportObject(modeloCa,0);
            ModeloHorarioAlumno modelo5 = (ModeloHorarioAlumno)UnicastRemoteObject.exportObject(modeloha,0);
            ModeloHorarioMaestro modelo6 = (ModeloHorarioMaestro)UnicastRemoteObject.exportObject(modelohma,0);
            ModeloMateria modelo7 = (ModeloMateria)UnicastRemoteObject.exportObject(modeloMat,0);
            //Localizar el rmiregistry, es decir que este abierto
            Registry registry = LocateRegistry.getRegistry();
            
            //Registrar el objeto en la red
            registry.rebind("ModeloAdministrador", modelo);
            registry.rebind("ModeloAlumno", modelo2);
            registry.rebind("ModeloMaestro", modelo3);
            registry.rebind("ModeloCarrera",modelo4);
            registry.rebind("ModeloHorarioAlumno",modelo5);
            registry.rebind("ModeloHorarioMaestro",modelo6);
            registry.rebind("ModeloMateria",modelo7);

            System.out.println("Servidor listo!!!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}