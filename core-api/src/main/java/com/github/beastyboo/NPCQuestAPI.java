package com.github.beastyboo;

import com.github.beastyboo.user.QuestUser;

import java.util.UUID;

public interface NPCQuestAPI {

    QuestUser getQuestUser(UUID uuid);

}
