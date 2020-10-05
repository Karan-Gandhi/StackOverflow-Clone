package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Routes.Routes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BindSocketServer {
    static final int PORT = 3000;
    static final boolean verbose = true;
    public static Thread thread = null;

    public static void bind() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(PORT);
                    System.out.println("[ServerSocket] Sucessful connected to port " + PORT);

                    while(true) createSocket(serverSocket.accept());
                } catch (IOException exception) {
                    System.out.println("[ServerSocket] ERROR: " + exception.getMessage());
                }
            }
        });
        thread.start();
    }

    static void createSocket(Socket socket) {
        if (verbose) System.out.println("[Socket] Connection opened at " + new Date());

        Thread thread = new Thread(new Routes(socket, verbose));
        thread.start();
    }
}
