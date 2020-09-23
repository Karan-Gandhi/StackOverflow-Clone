package com.karangandhi.stackoverflow.clone.Components;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    public UUID id;
    public String displayName, profilePic, username, password;
    public ArrayList<Reputation> reputation;
    public ArrayList<Question> questions;
    public ArrayList<Answer> answers;

    public User(String displayName, String profilePic, String username, String password) {
        this.displayName = displayName;
        this.profilePic = profilePic;
        this.username = username;
        this.password = password;
        this.reputation = new ArrayList<Reputation>();
        this.questions = new ArrayList<Question>();
        this.answers = new ArrayList<Answer>();
    }

    public User(UUID id, String displayName, String profilePic, String username, String password, ArrayList<Reputation> reputation, ArrayList<Question> questions, ArrayList<Answer> answers) {
        this.id = id;
        this.displayName = displayName;
        this.profilePic = profilePic;
        this.username = username;
        this.password = password;
        this.reputation = reputation;
        this.questions = questions;
        this.answers = answers;
    }
}
