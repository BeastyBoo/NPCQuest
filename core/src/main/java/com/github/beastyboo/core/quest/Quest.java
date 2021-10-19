package com.github.beastyboo.core.quest;

import com.github.beastyboo.core.NPCQuest;
import com.github.beastyboo.core.user.LastQuestProgressTracker;
import com.github.beastyboo.core.user.QuestUserImpl;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.AxolotlBucketMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Quest {

    private final NPCQuest core;
    private final String name;
    private final UUID uuid;
    private final Map<String, Stage> stages;

    private Stage firstStage;

    public Quest(NPCQuest core, String name, UUID uuid, Map<String, Stage> stages, Stage firstStage) {
        this.core = core;
        this.name = name;
        this.uuid = uuid;
        this.stages = stages;
        this.firstStage = firstStage;
    }

    public Quest(NPCQuest core, String name) {
        this(core, name, UUID.randomUUID(), new HashMap<>(), null);
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setFirstStage(Stage firstStage) {
        this.firstStage = firstStage;
    }

    public void attemptStartQuest(Player player) {
        if(firstStage == null) {
            player.sendMessage(Component.text("Quest: " + name + ": is not configured properly. Contact Administrator!"));
            return;
        }

        QuestUserImpl questUser = (QuestUserImpl) core.getQuestUser(player.getUniqueId());
        if (questUser == null) {
            player.sendMessage(Component.text("We could not load your user from our storage! Contact Administrator!"));
            return;
        }

        if(questUser.hasCompletedQuest(uuid)) {
            player.sendMessage(Component.text("You have already completed this quest!"));
            return;
        }

        LastQuestProgressTracker questProgressTracker = questUser.getLastQuestProgressTracker();

        if(questProgressTracker == null) {
            startQuest(player, questUser, firstStage);
        } else {
            if(questProgressTracker.questID().equals(uuid)) {
                Stage stage = stages.get(questProgressTracker.stageName().toLowerCase());
                if(stage == null) {
                    player.sendMessage(Component.text("Could not load previous stage! Resetting Quest"));
                    startQuest(player, questUser, firstStage);
                } else {
                    player.sendMessage(Component.text("Starting quest from previous saved Stage!"));
                    startQuest(player, questUser, stage);
                }
            } else {
                player.sendMessage(Component.text("You have not completed your previous Quest! Please complete it before returning here."));
            }
        }
    }

    private void startQuest(Player player, QuestUserImpl questUser, Stage stage) {
        stage.startStage(core, player, questUser);
    }

}
