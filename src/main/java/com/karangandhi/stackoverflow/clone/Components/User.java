package com.karangandhi.stackoverflow.clone.Components;

import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.karangandhi.stackoverflow.clone.Services.FirebaseAuthService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class User {
    public UUID id;
    public String displayName, profilePic, username, password, email;
    public ArrayList<Reputation> reputation;
    public ArrayList<Question> questions;
    public ArrayList<Answer> answers;

    public User(String displayName, String profilePic, String username, String password, String email) {
        this.displayName = displayName;
        this.profilePic = profilePic;
        this.username = username;
        this.password = password;
        this.reputation = new ArrayList<Reputation>();
        this.questions = new ArrayList<Question>();
        this.answers = new ArrayList<Answer>();
        this.email = email;
    }

    public User(UUID id, String displayName, String profilePic, String username, String password, ArrayList<Reputation> reputation, ArrayList<Question> questions, ArrayList<Answer> answers, String email) {
        this.id = id;
        this.displayName = displayName;
        this.profilePic = profilePic;
        this.username = username;
        this.password = password;
        this.reputation = reputation;
        this.questions = questions;
        this.answers = answers;
        this.email = email;
    }

    public void addQuestion(Question question) {}

    public void addAnswer(Answer answer) {}

    public void addUpvote() {
        this.reputation.add(new Reputation(this.id, "upvote"));
    }

    public void addDownVote() {
        this.reputation.add(new Reputation(this.id, "downvote"));
    }

    public static Pair<UserRecord, WriteResult> UploadUserToDatabase(User user) throws FirebaseAuthException, ExecutionException, InterruptedException {
        return FirebaseAuthService.createUser(user);
    }

    public static User getUserFromDatabase(UUID id) throws ExecutionException, InterruptedException {
        return FirebaseAuthService.getUser(id);
    }
}
