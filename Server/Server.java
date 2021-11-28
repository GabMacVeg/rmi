package Server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import Server.Modelo.ModeloUsuariosPersistente;
import Server.Modelo.ModeloProductosPersitente;

import Common.ModeloUsuarios;
import Common.ModeloProductos;

//Interface de mi objeto remoto


public class Server {
    

    public static void main(String[] args) {
        try {
            //Creo el objeto remoto
            ModeloUsuariosPersistente modeloP =  new ModeloUsuariosPersistente();
            ModeloProductosPersitente modeloProd =  new ModeloProductosPersitente();

            //Creo el stub, encargado de recibir parametros y de regresar informacion
            ModeloUsuarios modelo =  (ModeloUsuarios) UnicastRemoteObject.exportObject(modeloP, 0);
            ModeloProductos modelo2 =  (ModeloProductos)UnicastRemoteObject.exportObject(modeloProd, 0);
            
            //Localizar el rmiregistry, es decir que este abierto
            Registry registry = LocateRegistry.getRegistry();
            
            //Registrar el objeto en la red
            registry.rebind("ModeloUsuarios", modelo);
            registry.rebind("ModeloProductos", modelo2);

            System.out.println("Servidor listo!!!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}