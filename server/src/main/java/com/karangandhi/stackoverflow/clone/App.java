package com.karangandhi.stackoverflow.clone;

import com.karangandhi.stackoverflow.clone.Services.FirebaseAuthService;
import com.karangandhi.stackoverflow.clone.Services.FirebaseService;
import com.karangandhi.stackoverflow.clone.Services.FirestoreService;
import com.sun.corba.se.spi.activation.Server;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        try {
            FirebaseService.InitializeApp();
            FirestoreService.Init();
            FirebaseAuthService.Init();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void createServer() {

    }
}
