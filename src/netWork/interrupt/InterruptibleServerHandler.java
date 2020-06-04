package netWork.interrupt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InterruptibleServerHandler implements Runnable {

    @Override
    public void run() {
        int port = ServerParam.PORT;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new InterruptibleServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
