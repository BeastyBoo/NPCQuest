package com.github.beastyboo.core.quest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuestManager {

    private final CachedQuestTracker inMemoryQuests;
    private final Map<UUID, Objective> playerObjectives;

    public QuestManager() {
        inMemoryQuests = new CachedQuestTracker();
        playerObjectives = new HashMap<>();
    }

    public void addPlayerObjective(UUID uuid, Objective objective) {
        playerObjectives.put(uuid, objective);
    }

    public void removePlayerObjective(UUID uuid) {
        playerObjectives.remove(uuid);
    }

    public Objective getPlayerObjective(UUID uuid) {
        return playerObjectives.get(uuid);
    }

}
