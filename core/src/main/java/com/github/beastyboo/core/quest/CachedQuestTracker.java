package com.github.beastyboo.core.quest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CachedQuestTracker {

    private final Map<UUID, Quest> questByUUID;
    private final Map<String, Quest> questByName;

    CachedQuestTracker() {
        questByUUID = new HashMap<>();
        questByName = new HashMap<>();
    }

    void addQuestToCache(Quest quest) {
        questByUUID.put(quest.getUuid(), quest);
        questByName.put(quest.getName().toLowerCase(), quest);
    }

    public Quest getQuest(UUID uuid) {
        return questByUUID.get(uuid);
    }

    public Quest getQuest(String name) {
        return questByName.get(name.toLowerCase());
    }

}
