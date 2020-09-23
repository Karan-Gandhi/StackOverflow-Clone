package com.karangandhi.stackoverflow.clone.Services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class FireBase {
    public static FirebaseApp app;
    public static void InitializeApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("./src/secrets/stackoverflow-clone-firebase-adminsdk.json");
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://stackoverflow-clone-e882f.firebaseio.com")
                .build();
        app = FirebaseApp.initializeApp(firebaseOptions);
    }

    public static class Auth {
        public static UserRecord createUser(String displayName, UUID id, String email, String password) throws FirebaseAuthException {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setUid(id.toString())
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return userRecord;
        }
    }

    public static class Database {
        private static final FirebaseDatabase database = FirebaseDatabase.getInstance();

        public static void addData(String reference, Map<String, ?> data) {
            String collection = reference.substring(0, reference.lastIndexOf("/"));
            String document = reference.substring(reference.lastIndexOf("/"));
            DatabaseReference databaseReference = database.getReference(collection);
            DatabaseReference documentReference = databaseReference.child(document);
            documentReference.setValueAsync(data);
        }
    }
}
