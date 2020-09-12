package com.karangandhi.stackoverflow.clone.Components;

import java.util.ArrayList;

public class Answer {
    public String id, userID, body, status;
    public ArrayList<Reputation> upVotes, downVotes;
    public ArrayList<Report> reports;
    public ArrayList<Edit> edits;
    public ArrayList<Comment> comments;
}
