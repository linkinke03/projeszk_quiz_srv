package ConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientPool {
    final int PORT = 4567;
    ServerSocket ss;
    
    public ClientPool() throws IOException {
        ss = new ServerSocket(PORT);
        
    }
    
    public void startServer() throws IOException {
        while(true) {
            Socket s = ss.accept();
            ClientConnection client = new ClientConnection(s);
            client.start();
        }
    }
}
