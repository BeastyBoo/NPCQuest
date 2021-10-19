package com.github.beastyboo.core.user;

import java.util.Objects;
import java.util.UUID;

public record LastQuestProgressTracker(UUID questID, String stageName) {

    public LastQuestProgressTracker {
        Objects.requireNonNull(questID);
        Objects.requireNonNull(stageName);
    }

    @Override
    public UUID questID() {
        return questID;
    }

    @Override
    public String stageName() {
        return stageName;
    }
}
