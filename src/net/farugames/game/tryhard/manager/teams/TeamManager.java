package net.farugames.game.tryhard.manager.teams;

import net.farugames.game.tryhard.Tryhard;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public class TeamManager {
    public static List<TeamInfo> teamList = new ArrayList<TeamInfo>();
    public static Map<TeamInfo, List<Player>> playerTeamList = new HashMap<TeamInfo, List<Player>>();
    public static Map<TeamInfo, List<String>> playerNameList = new HashMap<TeamInfo, List<String>>();
    public static Map<TeamInfo, Location> teamLocationList = new HashMap<TeamInfo, Location>();

    public TeamManager() {}

    public static void addPlayerInTeam(Player player, TeamInfo teamInfo) {
        if(playerTeamList.get(teamInfo) == null) { playerTeamList.put(teamInfo, new ArrayList<Player>()); }
        playerTeamList.get(teamInfo).add(player);
    }

    public static void removePlayerInTeam(Player player, TeamInfo teamInfo) {
        playerTeamList.get(teamInfo).remove(player);
    }

    public static void removePlayerInAllTeam(Player player) {
        for(TeamInfo teamInfo : TeamInfo.values()) {
            if(playerTeamList.get(teamInfo) != null) {
                if(playerTeamList.get(teamInfo).contains(player)) {
                    playerTeamList.get(teamInfo).remove(player);
                    if(playerTeamList.get(teamInfo).isEmpty()
                            || playerTeamList.get(teamInfo).size() == 0) {
                        Tryhard.instance.teamInGameList.remove(teamInfo);
                    }
                }
            }
        }
    }

    public static void putInARandomTeam(Player player) {
        if(!(hasPlayerTeam(player))) {
            for(TeamInfo teamInfo : TeamInfo.values()) {
                if(playerTeamList.get(teamInfo).size() >= Tryhard.instance.maxPlayerPerTeam) {
                    teamList.remove(teamInfo);
                }
            }
            TeamInfo teamInfo = teamList.get(new Random().nextInt(teamList.size()));
            if(playerTeamList.get(teamInfo) == null) { playerTeamList.put(teamInfo, new ArrayList<Player>()); }
            playerTeamList.get(teamInfo).add(player);
        }
    }

    public static TeamInfo getPlayerTeam(Player player) {
        for(TeamInfo teamInfo : teamList) {
            if(playerTeamList.get(teamInfo).contains(player)) {
                return teamInfo;
            }
        }
        return null;
    }

    public static Location getTeamLocation(TeamInfo teamInfo) {
        return teamLocationList.get(teamInfo);
    }

    public static boolean isPlayerInTeam(Player player, TeamInfo teamInfo) {
        return playerTeamList.get(teamInfo).contains(player);
    }

    public static boolean hasPlayerTeam(Player player) {
        for(TeamInfo teamInfo : TeamInfo.values()) {
            if(playerTeamList.get(teamInfo).contains(player)) {
                return true;
            }
        }
        return false;
    }

    public static List<TeamInfo> getTeamList() {
        return teamList;
    }

    public static Map<TeamInfo, List<Player>> getPlayerTeamList() {
        return playerTeamList;
    }

    public static void fullAndChargeList() {
        for(TeamInfo teamInfo : TeamInfo.values()) {
            if(!(teamList.contains(teamInfo))) {
                teamList.add(teamInfo);
            }

            if(playerTeamList.get(teamInfo) == null) {
                playerTeamList.put(teamInfo, new ArrayList<Player>());
            }

            if(teamLocationList.get(teamInfo) == null) {
                Location locationRandom = (Location) Tryhard.spawnLocations.get(new Random().nextInt(Tryhard.spawnLocations.size()));
                teamLocationList.put(teamInfo, locationRandom);
                Tryhard.spawnLocations.remove(locationRandom);
            }
        }
    }

    public boolean teamIsFull(TeamInfo teamInfo) {
        if(playerTeamList.get(teamInfo).size() >= Tryhard.instance.maxPlayerPerTeam) {
            return true;
        }
        return false;
    }
}
