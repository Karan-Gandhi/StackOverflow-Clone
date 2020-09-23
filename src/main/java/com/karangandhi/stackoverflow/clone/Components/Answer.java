package com.karangandhi.stackoverflow.clone.Components;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Answer {
    public UUID id;
    public UUID userID;
    public String body;
    public String status;
    public ArrayList<Reputation> upVotes;
    public ArrayList<Reputation> downVotes;
    public ArrayList<Report> reports;
    public ArrayList<Edit> edits;
    public ArrayList<Comment> comments;

    public Answer(String body, UUID userID) {
        this.id = UUID.randomUUID();
        this.userID = userID;
        this.body = body;
        this.status = "NORMAL";
        this.upVotes = new ArrayList<Reputation>();
        this.downVotes = new ArrayList<Reputation>();
        this.reports = new ArrayList<Report>();
        this.edits = new ArrayList<Edit>();
        this.comments = new ArrayList<Comment>();
    }

    public Answer(UUID id, UUID userID, String body, String status, ArrayList<Reputation> upVotes, ArrayList<Reputation> downVotes, ArrayList<Report> reports, ArrayList<Edit> edits, ArrayList<Comment> comments) {
        this.id = id;
        this.userID = userID;
        this.body = body;
        this.status = status;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.reports = reports;
        this.edits = edits;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) ||
                Objects.equals(body, answer.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, body, status, upVotes, downVotes, reports, edits, comments);
    }
}
