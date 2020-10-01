package com.karangandhi.stackoverflow.clone.Services;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import com.karangandhi.stackoverflow.clone.Components.User;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirebaseService {
    public static FirebaseApp app;
    public static final boolean verbose = true;
    
    public static void InitializeApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/secrets/stackoverflow-clone-82cd2-firebase-adminsdk-zrtlk-521cad8fd0.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://stackoverflow-clone-82cd2.firebaseio.com")
                .build();
        app = FirebaseApp.initializeApp(options, "Stackoverflow-clone");
    }

    public static class Auth {
        public static FirebaseAuth auth;

        public static void Init() {
            auth = FirebaseAuth.getInstance(app);
        }

        public static Pair<UserRecord, WriteResult> createUser(User user) throws FirebaseAuthException, ExecutionException, InterruptedException {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(user.email)
                    .setUid(user.id.toString())
                    .setDisplayName(user.displayName)
                    .setPassword(user.password)
                    .setEmailVerified(false)
                    .setPhotoUrl(user.profilePic);

            UserRecord record = auth.createUser(request);
            WriteResult result = Database.addData("users", user.id.toString(), user);
            return new Pair<>(record, result);
        }
    }

    public static class Database {
        private static Firestore database;

        public static Firestore Init() {
            database = FirestoreClient.getFirestore(app);
            return database;
        }

        public static WriteResult addData(String reference, Map<String, ?> data) throws ExecutionException, InterruptedException {
            DocumentReference documentReference = database.document(reference);
            ApiFuture<WriteResult> result = documentReference.set(data);
            return result.get();
        }

        public static WriteResult addData(String collection, String document, Map<String, ?> data) throws ExecutionException, InterruptedException {
            DocumentReference documentReference = database.collection(collection).document(document);
            ApiFuture<WriteResult> result = documentReference.set(data);
            return result.get();
        }

        public static <T> WriteResult addData(String collection, String document, T data) throws ExecutionException, InterruptedException {
            DocumentReference documentReference = database.collection(collection).document(document);
            ApiFuture<WriteResult> result = documentReference.set(data);
            return result.get();
        }
    }
}
