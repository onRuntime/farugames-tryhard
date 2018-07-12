package net.farugames.game.tryhard.manager.runnable;

import net.farugames.api.tools.builders.title.TitleBuilder;
import net.farugames.api.tools.player.PlayerUtils;
import net.farugames.game.tryhard.TryHardPlayer;
import net.farugames.game.tryhard.Tryhard;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class LaunchRunnable extends BukkitRunnable {
    public static Integer timer = 5;
    public static boolean cageIsDestroy = false;

    @Override
    public void run() {
        if (!(cageIsDestroy)) {

            if (timer == 0) {
                Tryhard.instance.canMove = true;
                cageIsDestroy = true;
                timer = 5;

                for (Player playerOnline : Bukkit.getOnlinePlayers()) {

                    TryHardPlayer tryHardPlayer = Tryhard.getTryPlayer(playerOnline);

                    tryHardPlayer.getCages().removeCage();
                    playerOnline.playSound(playerOnline.getLocation(), Sound.ENTITY_ENDERDRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                    playerOnline.setWalkSpeed(0.2f);
                    playerOnline.setGameMode(GameMode.SURVIVAL);
                    PlayerUtils.clearInventory(playerOnline);

                    playerOnline.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
                    playerOnline.getInventory().addItem(new ItemStack(Material.STONE, 32));
                }

                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(Tryhard.getChatPrefix() + ChatColor.WHITE + " Les plates-formes sont maintenant détruites, que le meilleur gagne !");
                Bukkit.broadcastMessage("");


                return;
            }


            new TitleBuilder(ChatColor.AQUA + "" + timer, "").broadcast();
            timer--;
            return;
        }

        if (timer == 0) {
            Tryhard.instance.damage = true;
            this.cancel();
            return;
        }

        timer--;
        return;
    }
}
