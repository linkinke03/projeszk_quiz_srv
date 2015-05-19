package main;

import ConnectionHandler.ClientPool;
import java.io.IOException;

public class server {
    public static void main(String[] args) throws IOException {
        ClientPool cp = new ClientPool();
        cp.startServer();
        
        
    }
}
