package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Routes.Routes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class App {
    static final File WEB_ROOT = new File("./src/views");

    static final int PORT = 3000;
    static final boolean verbose = false;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("[ServerSocket] Sucessful connected to port " + PORT);

            while(true) {
                createSocket(serverSocket.accept());
            }
        } catch (IOException exception) {
            System.out.println("[ServerSocket] ERROR: " + exception.getMessage());
        }
    }

    static void createSocket(Socket socket) {
        if (verbose) System.out.println("[Socket] Connection opened at " + new Date());

        Thread thread = new Thread(new Routes(socket, verbose));
        thread.start();
    }
}
