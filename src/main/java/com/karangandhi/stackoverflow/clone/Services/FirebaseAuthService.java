package com.karangandhi.stackoverflow.clone.Services;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.karangandhi.stackoverflow.clone.Components.User;
import javafx.util.Pair;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static com.karangandhi.stackoverflow.clone.Services.FirebaseService.app;

public class FirebaseAuthService {
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
        WriteResult result = FirestoreService.addData("users", user.id.toString(), user);
        return new Pair<>(record, result);
    }

    public static String signInWithEmailAndPassword(String email, String password) throws FirebaseAuthException {
        User found = null;
        try {
            List<QueryDocumentSnapshot> users = FirestoreService.getCollectionSnapshot("users");
            for (QueryDocumentSnapshot userDocumentSnapshot : users) {
                User user = userDocumentSnapshot.toObject(User.class);
                if (user.email.equalsIgnoreCase(email) && user.password.equals(password) && user.password.equals(password)) {
                    found = user;
                    break;
                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return found == null ? null : auth.createCustomToken(found.id.toString());
    }

    public static String signInWithUsernameAndPassword(String username, String password) throws FirebaseAuthException {
        User found = null;
        try {
            List<QueryDocumentSnapshot> users = FirestoreService.getCollectionSnapshot("users");
            for (QueryDocumentSnapshot userDocumentSnapshot : users) {
                User user = userDocumentSnapshot.toObject(User.class);
                if (user.username.equalsIgnoreCase(username) && user.password.equals(password)) {
                    found = user;
                    break;
                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return found == null ? null : auth.createCustomToken(found.id.toString());
    }

    public static Pair<FirebaseToken, User> verifyToken(String token) throws FirebaseAuthException, ExecutionException, InterruptedException {
        FirebaseToken firebaseToken = auth.verifyIdToken(token);
        User user = getUser(UUID.fromString(firebaseToken.getUid()));
        return new Pair(firebaseToken, user);
    }

    public static User getUser(UUID id) throws ExecutionException, InterruptedException {
        return FirestoreService.readData("users", id.toString()).toObject(User.class);
    }
}
