package com.github.beastyboo.core.quest.timer;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

abstract class Countdown {

    private final Plugin plugin;
    private int time;

    BukkitTask task;

    Countdown(Plugin plugin, int time) {
        this.plugin = plugin;
        this.time = time;
    }

    abstract void count(int current);

    final void start() {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                count(time);
                if (time-- <= 0) cancel();
            }

        }.runTaskTimer(plugin, 0L, 20L);
    }

    BukkitTask getTask() {
        return task;
    }
}
