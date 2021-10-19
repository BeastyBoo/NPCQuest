package com.github.beastyboo.core;

import com.github.beastyboo.NPCQuestAPI;
import com.github.beastyboo.core.quest.QuestManager;
import com.github.beastyboo.core.user.QuestUserManager;
import com.github.beastyboo.user.QuestUser;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.logging.Logger;

public class NPCQuest implements NPCQuestAPI {

    private final JavaPlugin plugin;
    private final Logger logger;

    private QuestManager questManager;
    private QuestUserManager questUserManager;

    NPCQuest(JavaPlugin plugin) {
        this.plugin = plugin;
        logger = plugin.getLogger();
    }

    void load() {
        questManager = new QuestManager();
        questUserManager = new QuestUserManager();
    }

    void close() {

    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    @Override
    public QuestUser getQuestUser(UUID uuid) {
        return questUserManager.getQuestUser(uuid);
    }
}
