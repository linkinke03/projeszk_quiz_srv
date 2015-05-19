package ConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientPool {
    final int PORT = 4567;
    ServerSocket ss;
    
    /**
     * Létrehozza a szerver socketet.
     * @throws IOException Kommunikációs hiba esetén
     */
    public ClientPool() throws IOException {
        ss = new ServerSocket(PORT);
        
    }
    
    /**
     * Elindítja a szervert és a klienskapcsolatokat.
     * @throws IOException Kommunikációs hiba esetén
     */
    public void startServer() throws IOException {
        while(true) {
            Socket s = ss.accept();
            ClientConnection client = new ClientConnection(s);
            client.start();
        }
    }
}
