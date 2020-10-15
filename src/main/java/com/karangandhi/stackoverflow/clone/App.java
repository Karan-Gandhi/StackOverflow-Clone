package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Services.FirebaseAuthService;
import com.karangandhi.stackoverflow.clone.Services.FirebaseService;
import com.karangandhi.stackoverflow.clone.Services.FirestoreService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {
        System.out.println("Entered the server");
        WebServlet.bind(Integer.parseInt(String.valueOf(System.getenv("PORT"))));
//        try {
//            FirebaseService.InitializeApp();
//            FirestoreService.Init();
//            FirebaseAuthService.Init();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (InterruptedException exception) {
//            exception.printStackTrace();
//        } catch (ExecutionException exception) {
//            exception.printStackTrace();
//        }
    }

    public static void createServer() {

    }
}
