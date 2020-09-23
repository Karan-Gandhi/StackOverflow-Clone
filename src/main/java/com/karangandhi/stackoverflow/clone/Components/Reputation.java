package com.karangandhi.stackoverflow.clone.Components;

import java.util.Objects;
import java.util.UUID;

public class Reputation {
    private UUID id;
    private UUID userID;
    public String type;

    public Reputation(UUID userID, String type) {
        this.userID = userID;
        this.type = type;
        this.id = UUID.randomUUID();
    }

    public Reputation(UUID id, UUID userID, String type) {
        this.id = id;
        this.userID = userID;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reputation that = (Reputation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userID, that.userID) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, type);
    }
}
