package com.karangandhi.stackoverflow.clone.Components;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Question {
    public UUID id;
    public UUID userID;
    public String title;
    public String body;
    public String status;
    public ArrayList<Edit> edits;
    public ArrayList<Reputation> upVotes;
    public ArrayList<Reputation> downVotes;
    public ArrayList<Report> reports;
    public ArrayList<Answer> answers;
    public ArrayList<Comment> comments;

    public Question(String title, String body, UUID userID) {
        this.title = title;
        this.body = body;
        this.userID = userID;
        this.id = UUID.randomUUID();
        this.edits = new ArrayList<Edit>();
        this.upVotes = new ArrayList<Reputation>();
        this.downVotes = new ArrayList<Reputation>();
        this.reports = new ArrayList<Report>();
        this.answers = new ArrayList<Answer>();
        this.comments = new ArrayList<Comment>();
        this.status = "open";
    }

    public Question(UUID id, UUID userID, String title, String body, String status, ArrayList<Edit> edits, ArrayList<Reputation> upVotes, ArrayList<Reputation> downVotes, ArrayList<Report> reports, ArrayList<Answer> answers, ArrayList<Comment> comments) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.body = body;
        this.status = status;
        this.edits = edits;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.reports = reports;
        this.answers = answers;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) ||
                Objects.equals(title, question.title) ||
                Objects.equals(body, question.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, title, body, status, edits, upVotes, downVotes, reports, answers, comments);
    }
}
