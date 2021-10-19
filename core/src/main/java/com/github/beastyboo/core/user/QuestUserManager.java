package com.github.beastyboo.core.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuestUserManager {

    private final Map<UUID, QuestUserImpl> questUsers;

    public QuestUserManager() {
        questUsers = new HashMap<>();
    }

    public QuestUserImpl getQuestUser(UUID uuid) {
        return questUsers.get(uuid);
    }
}
