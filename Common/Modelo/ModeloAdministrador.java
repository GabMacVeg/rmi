package Common.Modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Common.Dataobjects.Administrador;

public interface ModeloAdministrador extends Remote{  

    Administrador login(String user, String pass) throws RemoteException;
    public void alta(Administrador admin) throws RemoteException;
    public boolean buscarAdmin(String user) throws RemoteException;
    
}