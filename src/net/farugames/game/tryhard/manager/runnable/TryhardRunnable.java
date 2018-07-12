package net.farugames.game.tryhard.manager.runnable;

import net.farugames.game.tryhard.Tryhard;
import net.farugames.game.tryhard.manager.GameManager;
import net.farugames.game.tryhard.manager.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class TryhardRunnable extends BukkitRunnable {
    public static int timer = 120;
    public static boolean start = false;
    public static boolean startCommand = false;

    public TryhardRunnable() {}

    @Override
    public void run() {

        if(!(GameStatus.isStatus(GameStatus.LOBBY))) {
            timer = 60;
            start = false;
            this.cancel();
            return;
        }

        if(Bukkit.getOnlinePlayers().size() < Tryhard.instance.minPlayers && startCommand == false) {
            Bukkit.broadcastMessage(ChatColor.RED + "Il n'y a pas assez de joueurs pour démarrer la partie.");
            timer = 60;
            start = false;
            sendXPExtern();
            this.cancel();
            return;
        }

        if(timer == 0){
            new GameManager().loadGame();
            this.cancel();
            return;
        }

        if((timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer <= 5 && timer != 0)){
            Bukkit.broadcastMessage(Tryhard.getChatPrefix() + "§eLa partie commence dans §6" + timer + getSecond() + "§e.");
        }

        sendXPExtern();
        timer--;
    }

    public void sendXPExtern() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.setLevel(timer);
//            if(ScoreboardManager.scoreboardGame.containsKey(player)) {
//                ScoreboardManager.scoreboardGame.get(player).setLine(7, "§7Lancement: §f" + new SimpleDateFormat("mm:ss").format(new Date(TryhardRunnable.timer * 1000)));
//            }
        }
    }

    private String getSecond(){
        return timer == 1 ? " seconde" : " secondes";
    }
}
