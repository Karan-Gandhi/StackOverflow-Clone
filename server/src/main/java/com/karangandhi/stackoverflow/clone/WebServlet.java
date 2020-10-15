package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Routes.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// TODO: turn this into a tcp and write http server in c++
public class WebServlet extends HttpServlet {
    static final boolean verbose = true;
    public static Thread thread = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("text/plain");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("Hello world");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    //    public static void bind(final int PORT) {
//        thread = new Thread(new Runnable() { // run the socket server on another thread to prevent the blocking of the main thread!
//            @Override
//            public void run() {
//                try {
//                    ServerSocket serverSocket = new ServerSocket(PORT);
//                    System.out.println("[ServerSocket] Successful connected to port " + PORT);
//
//                    while(true) createSocket(serverSocket.accept());
//                } catch (IOException exception) {
//                    System.out.println("[ServerSocket] ERROR: " + exception.getMessage());
//                }
//            }
//        });
//        thread.start();
//    }
//
//    static void createSocket(Socket socket) {
//        if (verbose) System.out.println("[Socket] Connection opened at " + new Date());
//        Thread thread = new Thread(new Routes(socket, verbose));
//        thread.start();
//    }
}
