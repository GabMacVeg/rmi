package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Common.Dataobjects.Maestro;

public interface ModeloMaestro extends Remote{  

    Maestro login(String user, String pass) throws RemoteException;
    public void alta(Maestro maestro) throws RemoteException;
    public boolean buscarMaestro(String user) throws RemoteException;
    public String buscarNombre(String user) throws RemoteException;
    public int buscarMatricula(String user) throws RemoteException; 
    public void setMsg(String msg) throws RemoteException;
    public void eliminar(String user) throws RemoteException;

}