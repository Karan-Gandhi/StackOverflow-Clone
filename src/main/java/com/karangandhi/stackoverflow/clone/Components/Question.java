package com.karangandhi.stackoverflow.clone.Components;

import java.util.ArrayList;

public class Question {
    public String id, title, body, userID, status;
    public ArrayList<Edit> edits;
    public ArrayList<Reputation> upVotes, downVotes;
    public ArrayList<Report> reports;
    public ArrayList<Answer> answers;
    public ArrayList<Comment> comments;
}
