package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import Common.Dataobjects.Carrera;

public interface ModeloCarrera extends Remote{    
    //public ArrayList<Producto> getProductos() throws RemoteException;
    public void alta(Carrera carrera) throws RemoteException;
    public boolean buscarCarrera(String id) throws RemoteException;
}