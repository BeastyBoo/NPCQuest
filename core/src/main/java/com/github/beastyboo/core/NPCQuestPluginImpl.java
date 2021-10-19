package com.github.beastyboo.core;

import com.github.beastyboo.NPCQuestAPI;
import com.github.beastyboo.NPCQuestPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NPCQuestPluginImpl extends JavaPlugin implements NPCQuestPlugin {

    private NPCQuest core;

    @Override
    public void onEnable() {
        core = new NPCQuest(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

    @Override
    public NPCQuestAPI getAPI() {
        return core;
    }
}
