package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import Common.Dataobjects.HorarioMaestro;

public interface ModeloHorarioMaestro extends Remote{    
    //public ArrayList<Producto> getProductos() throws RemoteException;
    public void alta(HorarioMaestro horarioMaestro) throws RemoteException;
    public boolean buscarMateria(String nombre) throws RemoteException;
    
    
}