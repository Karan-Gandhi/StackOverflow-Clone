package com.karangandhi.stackoverflow.clone.Components;

import java.util.Objects;
import java.util.UUID;

public class Edit {
    public UUID id;
    public UUID userID;
    public String body;
    public String status;

    public Edit(UUID userID, String body) {
        this.userID = userID;
        this.body = body;
        this.id = UUID.randomUUID();
        this.status = "NORMAL";
    }

    public Edit(UUID userID, UUID id, String body, String status) {
        this.userID = userID;
        this.id = id;
        this.body = body;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edit edit = (Edit) o;
        return Objects.equals(body, edit.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, body, status);
    }
}
