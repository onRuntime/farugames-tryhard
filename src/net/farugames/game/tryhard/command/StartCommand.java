package net.farugames.game.tryhard.command;

import net.farugames.game.tryhard.Tryhard;
import net.farugames.game.tryhard.manager.runnable.TryhardRunnable;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (Tryhard.instance.minPlayers > Bukkit.getOnlinePlayers().size()) {
                new TryhardRunnable().runTaskTimer(Tryhard.instance, 0L, 20L);
                TryhardRunnable.start = true;
            }
            TryhardRunnable.timer = 10;
            TryhardRunnable.startCommand = true;
            Bukkit.broadcastMessage(Tryhard.getChatPrefix() + "§6§l" + sender.getName() + " §ca forcé le démarrage de la partie !");
        }
        return false;
    }

}