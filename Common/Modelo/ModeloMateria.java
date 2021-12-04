package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import Common.Dataobjects.Materia;

public interface ModeloMateria extends Remote{    
    //public ArrayList<Producto> getProductos() throws RemoteException;
    public void alta(Materia materia) throws RemoteException;
    public Materia buscarMateria(String nombre) throws RemoteException;
}