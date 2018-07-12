package net.farugames.game.tryhard.manager.runnable;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by SweetKebab_ on 2018-07-12
 */
public class GameRunnable extends BukkitRunnable {
    public static Integer time = 0;

    @Override
    public void run() {
        time++;
        return;
    }
}
