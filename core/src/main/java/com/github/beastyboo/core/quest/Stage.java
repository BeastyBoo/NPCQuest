package com.github.beastyboo.core.quest;

import com.github.beastyboo.core.NPCQuest;
import com.github.beastyboo.core.user.LastQuestProgressTracker;
import com.github.beastyboo.core.user.QuestUserImpl;
import org.bukkit.entity.Player;

public class Stage {

    private final String name;
    private final Objective objective;

    public Stage(String name, Objective objective) {
        this.name = name;
        this.objective = objective;
    }

    public String getName() {
        return name;
    }

    public void startStage(NPCQuest core, Player player, QuestUserImpl questUser) {
        Objective deepCopy = objective.deepCopy();

        LastQuestProgressTracker lastQuestProgressTracker = questUser.getLastQuestProgressTracker();
        questUser.setLastQuestProgressTracker(new LastQuestProgressTracker(lastQuestProgressTracker.questID(), name.toLowerCase()));

        core.getQuestManager().addPlayerObjective(player.getUniqueId(), deepCopy);
        deepCopy.start(player, questUser);
    }
}
