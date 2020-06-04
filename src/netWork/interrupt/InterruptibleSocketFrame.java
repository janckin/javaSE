package netWork.interrupt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InterruptibleSocketFrame extends JFrame {
    private Scanner in;
    private JButton interruptButton;
    private JButton cancelButton;
    private JButton blockingButton;
    private JTextArea message;
    private InterruptibleServerHandler serverHandler;
    private Thread currentThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        final int TEXT_ROWS = 20;
        final int TEXT_COLUMNS = 60;
        message = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(message));

        interruptButton = new JButton("interruptible");
        northPanel.add(interruptButton);

        blockingButton = new JButton("Blocking");
        northPanel.add(blockingButton);

        cancelButton = new JButton("cancel");
        northPanel.add(cancelButton);

        //setting button action
        interruptButton.addActionListener((event) -> {
            interruptButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);

            currentThread = new Thread(this::interruptedConnect);
            currentThread.start();
        });

        blockingButton.addActionListener((event) -> {
            interruptButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);

            currentThread = new Thread(this::blockingConnect);
            currentThread.start();
        });


        cancelButton.addActionListener((event) -> {
            if (!currentThread.isInterrupted()) {
                currentThread.interrupt();
                cancelButton.setEnabled(true);
            }
        });

        //running server
        serverHandler = new InterruptibleServerHandler();
        new Thread(serverHandler, "serverHandler").start();

        pack();
    }

    private void blockingConnect() {
        int port = ServerParam.PORT;
        String host = ServerParam.HOST;
        message.append("blockingConnect start! :" + System.getProperty("line.separator"));
        try (Socket socket = new Socket(host, port)) {
            in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            while (!Thread.currentThread().isInterrupted()) {
                message.append("Reading -> ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    message.append(line);
                    message.append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EventQueue.invokeLater(() -> {
                message.append(System.getProperty("line.separator"));
                message.append("socket closed!");
                message.append(System.getProperty("line.separator"));
                interruptButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    private void interruptedConnect() {
        int port = ServerParam.PORT;
        String host = ServerParam.HOST;
        message.append("Interruptible:" + System.getProperty("line.separator"));
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(host, port))) {
            in = new Scanner(socketChannel, StandardCharsets.UTF_8);
            while (!Thread.currentThread().isInterrupted()) {
                message.append("Reading -> ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    message.append(line);
                    message.append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EventQueue.invokeLater(() -> {
                message.append(System.getProperty("line.separator"));
                message.append("channel closed!");
                message.append(System.getProperty("line.separator"));
                interruptButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

}
