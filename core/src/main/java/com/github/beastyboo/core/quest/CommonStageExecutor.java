package com.github.beastyboo.core.quest;

import com.github.beastyboo.core.NPCQuest;
import com.github.beastyboo.core.user.LastQuestProgressTracker;
import com.github.beastyboo.core.user.QuestUserImpl;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class CommonStageExecutor {

    private final NPCQuest core;
    private final Stage stage;
    private final QuestUserImpl questUser;

    public CommonStageExecutor(NPCQuest core, Stage stage, QuestUserImpl questUser) {
        this.core = core;
        this.stage = stage;
        this.questUser = questUser;
    }

    public void attemptProceed(Player player) {
        core.getQuestManager().removePlayerObjective(player.getUniqueId());

        if(stage == null) {
            LastQuestProgressTracker lastQuestProgressTracker = questUser.getLastQuestProgressTracker();
            questUser.addCompletedQuest(lastQuestProgressTracker.questID());
            questUser.setLastQuestProgressTracker(null);
            player.sendMessage(Component.text("Quest completed!"));
        } else {
            stage.startStage(core, player, questUser);
        }
    }
}