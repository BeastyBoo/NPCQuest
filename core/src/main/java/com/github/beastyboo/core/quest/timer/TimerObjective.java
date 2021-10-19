package com.github.beastyboo.core.quest.timer;

import com.github.beastyboo.core.NPCQuest;
import com.github.beastyboo.core.quest.Objective;
import com.github.beastyboo.core.user.QuestUserImpl;
import org.bukkit.entity.Player;

public interface TimerObjective extends Objective {

    @Override
    void start(Player player, QuestUserImpl questUser);

    int timeInSeconds();

    void complete();

    default void startTimer(NPCQuest core, Player player, QuestUserImpl questUser) {
        new Countdown(core.getPlugin(), timeInSeconds()) {
            @Override
            void count(int current) {
                complete();
            }
        }.start();
    }
}
