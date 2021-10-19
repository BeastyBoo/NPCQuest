package com.github.beastyboo.core.user;

import com.github.beastyboo.user.QuestUser;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class QuestUserImpl implements QuestUser {

    private final UUID uuid;
    private final Set<UUID> completedQuests;

    private LastQuestProgressTracker lastQuestProgressTracker;

    public QuestUserImpl(UUID uuid, Set<UUID> completedQuests, LastQuestProgressTracker questProgressTracker) {
        this.uuid = uuid;
        this.completedQuests = completedQuests;
        this.lastQuestProgressTracker = questProgressTracker;
    }

    public QuestUserImpl(UUID uuid) {
        this(uuid, new HashSet<>(), null);
    }

    public boolean hasCompletedQuest(UUID uuid) {
        return completedQuests.contains(uuid);
    }

    public void addCompletedQuest(UUID uuid) {
        completedQuests.add(uuid);
    }

    public void setLastQuestProgressTracker(LastQuestProgressTracker lastQuestProgressTracker) {
        this.lastQuestProgressTracker = lastQuestProgressTracker;
    }

    public LastQuestProgressTracker getLastQuestProgressTracker() {
        return lastQuestProgressTracker;
    }
}
