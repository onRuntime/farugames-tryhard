package net.farugames.game.tryhard.listeners;

import net.farugames.game.tryhard.TryHardPlayer;
import net.farugames.game.tryhard.Tryhard;
import net.farugames.game.tryhard.manager.GameStatus;
import net.farugames.game.tryhard.manager.runnable.TryhardRunnable;
import net.farugames.game.tryhard.manager.teams.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by SweetKebab_ on 2018-07-10
 */
public class PlayerJoinLeaveListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        TryHardPlayer tryHardPlayer = Tryhard.getTryPlayer(player);
        if (!GameStatus.isStatus(GameStatus.LOBBY)) {
            tryHardPlayer.setSpectator();

            // Message pour un Spectateur qui rejoins.
            player.sendMessage("");
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "ATTENTION " + ChatColor.GRAY + ""
                    + ChatColor.YELLOW + "Il vous est impossible de jouer !");
            player.sendMessage(ChatColor.AQUA + "Vous avez rejoint la partie en mode spectateur.");
            player.sendMessage("");
            return;
        }
        player.setGameMode(GameMode.ADVENTURE);
        player.setMaxHealth(20);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getInventory().clear();
        player.teleport(new Location(Bukkit.getWorld("world"), -329.5, 137 + 2, -203.5, 90.0f, 0.0f));


        if ((Bukkit.getOnlinePlayers().size() >= Tryhard.instance.minPlayers) && (!(TryhardRunnable.start))) {
            new TryhardRunnable().runTaskTimer(Tryhard.instance, 0L, 20L);
            TryhardRunnable.start = true;
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        TryHardPlayer gamePlayer = Tryhard.getTryPlayer(player);
        event.setQuitMessage(null);
        TeamManager.removePlayerInAllTeam(player);
        gamePlayer.rewardMessage();
    }
}
