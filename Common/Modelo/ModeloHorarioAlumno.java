package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import Common.Dataobjects.HorarioAlumno;

public interface ModeloHorarioAlumno extends Remote{    
    //public ArrayList<Producto> getProductos() throws RemoteException;
    public void alta(HorarioAlumno horarioAlumno) throws RemoteException;
    public boolean buscarMateria(String nombre) throws RemoteException;
    public boolean buscarMateriaC(String materia,String alumno, float calif) throws RemoteException;
}