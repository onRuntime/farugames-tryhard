package net.farugames.game.tryhard.listeners;

import net.farugames.game.tryhard.Tryhard;
import net.farugames.game.tryhard.manager.runnable.GameRunnable;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
//        if(GameStatus.isStatus(GameStatus.LOBBY)) {
//            if(player.getLocation().getBlockY() < 120) {
//                player.teleport(new Location(Bukkit.getWorld("world"), -329.5, 137 + 2, -203.5, 90.0f, 0.0f));
//            }
//        }
        if ((!(Tryhard.instance.canMove))
                && (!(Tryhard.getTryPlayer(player).isSpectator))) {
            if (event.getFrom().getX() != event.getTo().getX() || event.getFrom().getY() != event.getTo().getY()
                    || event.getFrom().getZ() != event.getTo().getZ()) {
                Location loc = event.getFrom();
                event.getPlayer().teleport(loc.setDirection(event.getTo().getDirection()));
            }
        }
        if(event.getTo().getBlockY() <= 11 && GameRunnable.time < 30){

        }


    }

}
