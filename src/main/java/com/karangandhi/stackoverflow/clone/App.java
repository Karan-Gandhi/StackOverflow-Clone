package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Services.FirebaseAuthService;
import com.karangandhi.stackoverflow.clone.Services.FirebaseService;
import com.karangandhi.stackoverflow.clone.Services.FirestoreService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class App {
    static final File WEB_ROOT = new File("./src/views");

    static final int PORT = 3000;
    static final boolean verbose = true;

    public static void main(String[] args) {
        try {
            FirebaseService.InitializeApp();
            FirestoreService.Init();
            FirebaseAuthService.Init();
            BindSocketServer.bind();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
