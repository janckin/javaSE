package netWork.interrupt;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class InterruptibleServer implements Runnable {

    private Socket socket;
    private int counter;

    public InterruptibleServer(Socket socket) {
        this.socket = socket;
        this.counter = 0;
    }

    public InterruptibleServer() {

    }

    @Override
    public void run() {
        try (OutputStream out = socket.getOutputStream()) {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8), true);
            while (counter < 100) {
                counter++;
                if (counter <= 10) {
                    printWriter.println(counter);
                }
                Thread.sleep(100);
            }
            printWriter.println(System.getProperty("line.separator"));
            printWriter.println("close the server!");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
