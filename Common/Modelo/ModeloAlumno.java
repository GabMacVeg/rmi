package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Common.Dataobjects.Alumno;

public interface ModeloAlumno extends Remote{  

    Alumno login(String user, String pass) throws RemoteException;
    public void alta(Alumno alumno) throws RemoteException;
    public boolean buscarAlumno(String user) throws RemoteException;
    public int buscarMatricula(String user) throws RemoteException;
    public String buscarNombre(String user) throws RemoteException;
    public void eliminar(String user) throws RemoteException;

}