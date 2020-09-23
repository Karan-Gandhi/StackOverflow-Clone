package com.karangandhi.stackoverflow.clone.Components;

import java.util.Objects;
import java.util.UUID;

public class Comment {
    public UUID id;
    public UUID userID;
    public String body;

    public Comment(String body, UUID userID) {
        this.body = body;
        this.userID = userID;
        this.id = UUID.randomUUID();
    }

    public Comment(UUID id, UUID userID, String body) {
        this.id = id;
        this.userID = userID;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) ||
                Objects.equals(body, comment.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, body);
    }
}
