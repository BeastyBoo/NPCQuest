package com.github.beastyboo.core.quest;

import com.github.beastyboo.core.user.QuestUserImpl;
import org.bukkit.entity.Player;

public interface Objective{

    void start(Player player, QuestUserImpl questUser);

    Objective deepCopy();

}
