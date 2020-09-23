package com.karangandhi.stackoverflow.clone.Components;

import java.util.UUID;

public class Report {
    public UUID id;
    public UUID userID;
    public String type;

    public Report(UUID userID, String type) {
        this.id = UUID.randomUUID();
        this.userID = userID;
        this.type = type;
    }

    public Report(UUID id, UUID userID, String type) {
        this.id = id;
        this.userID = userID;
        this.type = type;
    }
}
