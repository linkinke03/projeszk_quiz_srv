package main;

import ConnectionHandler.ClientConnection;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) throws RemoteException{
        ClientConnection remoteClient = new ClientConnection();
        Registry registry = LocateRegistry.createRegistry(9876);
        registry.rebind("srv", remoteClient);
    }
}
