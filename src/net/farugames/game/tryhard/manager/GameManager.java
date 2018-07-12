package net.farugames.game.tryhard.manager;

import net.farugames.game.tryhard.TryHardPlayer;
import net.farugames.game.tryhard.Tryhard;
import net.farugames.game.tryhard.manager.cages.Cages;
import net.farugames.game.tryhard.manager.runnable.LaunchRunnable;
import net.farugames.game.tryhard.manager.teams.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class GameManager {
    public void loadGame() {
        GameStatus.setStatus(GameStatus.GAME);
        for(Player player : Bukkit.getOnlinePlayers()){
            TryHardPlayer tryHardPlayer = Tryhard.getTryPlayer(player);

            TeamManager.putInARandomTeam(player);
            Location locationTeam = TeamManager.getTeamLocation(TeamManager.getPlayerTeam(player));


            Location locationCage = new Location(Bukkit.getWorld("world"), locationTeam.getX(), (locationTeam.getY() + 10), locationTeam.getZ());
            tryHardPlayer.setCages(new Cages(tryHardPlayer.getCagesInfo(), locationCage));
            tryHardPlayer.getCages().createCage();

            Location locationTP = new Location(Bukkit.getWorld("world"), locationCage.getX(), (locationCage.getY() + 1), locationCage.getZ());
            player.teleport(locationTP);

            player.getInventory().clear();
            player.setMaxHealth(20.0);
            player.setHealth(20.0);
            player.setFoodLevel(200);
            player.setWalkSpeed(0.0f);
            player.setFlying(false);
            player.setAllowFlight(false);

            tryHardPlayer.setTeamInfo(TeamManager.getPlayerTeam(player));
            if(!Tryhard.instance.teamInGameList.contains(TeamManager.getPlayerTeam(player))) { Tryhard.instance.teamInGameList.add(TeamManager.getPlayerTeam(player)); }
            if(!(TeamManager.playerNameList.containsKey(TeamManager.getPlayerTeam(player)))) { TeamManager.playerNameList.put(TeamManager.getPlayerTeam(player), new ArrayList<String>()); }
            TeamManager.playerNameList.get(TeamManager.getPlayerTeam(player)).add(player.getName());

            tryHardPlayer.makeScoreboard();

            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(Tryhard.getChatPrefix()+ChatColor.GOLD+" La partie est lancé. La destruction de vos plates-formes aura lieu dans "
                    + ChatColor.AQUA + "5 secondes" + ChatColor.GOLD + ".");
            new LaunchRunnable().runTaskTimer(Tryhard.instance, 0L, 20L);
        }
    }
}
