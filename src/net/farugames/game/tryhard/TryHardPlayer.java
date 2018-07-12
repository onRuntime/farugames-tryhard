package net.farugames.game.tryhard;

import net.farugames.api.tools.board.ScoreboardSign;
import net.farugames.game.tryhard.manager.GameStatus;
import net.farugames.game.tryhard.manager.cages.CageEnum;
import net.farugames.game.tryhard.manager.cages.Cages;
import net.farugames.game.tryhard.manager.teams.TeamInfo;
import org.bukkit.entity.Player;

/**
 * Created by SweetKebab_ on 2018-07-10
 */
public class TryHardPlayer {

    public boolean isSpectator;
    private int kills;
    private Cages cages;
    private CageEnum cagesInfo = CageEnum.DEFAULT;
    private TeamInfo teamInfo;
    private ScoreboardSign scoreBoard;
    private Player player;


    public TryHardPlayer(Player player){
        if (GameStatus.isStatus(GameStatus.LOBBY)) {
            this.isSpectator = false;
        } else {
            this.isSpectator = true;
        }
        this.player = player;
        this.scoreBoard = new ScoreboardSign(player, player.getName());

        this.scoreBoard.setObjectiveName(Tryhard.getPrefix());
        this.scoreBoard.create();

        this.makeScoreboard();
    }

    public void makeScoreboard() {
        if(isSpectator){
            this.scoreBoard.setLine(5,
                    "§7Joueurs: §9" + Tryhard.instance.playerLeft);
            this.scoreBoard.setLine(7, "§7Carte: Â§b" + Tryhard.instance.mapGameInfos.getMapName());
            this.scoreBoard.setLine(8, "§5");
            this.scoreBoard.setLine(9, "§eplay.farugames.net");
            this.scoreBoard.setLine(10, "§8§m+---------------+");

        }
        if (GameStatus.isStatus(GameStatus.GAME)) {
            this.scoreBoard.removeLine(11);
            this.scoreBoard.setLine(1, "§1");
            this.scoreBoard.setLine(2, "§2");
            this.scoreBoard.setLine(3, "§7Kills: §a" + getKills());
            this.scoreBoard.setLine(4, "§3");
            this.scoreBoard.setLine(5,
                    "§7Joueurs: §9" + Tryhard.instance.playerLeft);
            this.scoreBoard.setLine(6, "§4");
            this.scoreBoard.setLine(7, "§7Carte: §b" + Tryhard.instance.mapGameInfos.getMapName());
            this.scoreBoard.setLine(8, "§5");
            this.scoreBoard.setLine(9, "§eplay.farugames.net");
            this.scoreBoard.setLine(10, "§8§m+---------------+");
        } else if (GameStatus.isStatus(GameStatus.FINISH)){
            this.scoreBoard.destroy();
        }
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setSpectator() {
        this.isSpectator = true;

        makeScoreboard();
    }


    public CageEnum getCagesInfo() {
        return cagesInfo;
    }

    public Cages getCages() {
        return cages;
    }

    public void setCages(Cages cages) {
        this.cages = cages;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public void rewardMessage() {
        player.sendMessage("Reward_message_here");
    }
}
