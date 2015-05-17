package main;

import ConnectionHandler.ClientConnection;
import entities.quiz;
import entities.quizJpaController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class server {
    public static void main(String[] args) throws RemoteException{
        ClientConnection remoteClient = new ClientConnection();
        Registry registry = LocateRegistry.createRegistry(9876);
        registry.rebind("srv", remoteClient);
        
       /* EntityManagerFactory factory = Persistence.createEntityManagerFactory("quiz_serverPU");
        quizJpaController quizjpac=new quizJpaController(factory);
        
        System.out.println(quizjpac.getRandomQuiz());*/
    }
}
