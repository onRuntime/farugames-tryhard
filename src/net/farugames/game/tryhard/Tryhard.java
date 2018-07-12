package net.farugames.game.tryhard;

import net.farugames.game.tryhard.command.StartCommand;
import net.farugames.game.tryhard.listeners.PlayerJoinLeaveListener;
import net.farugames.game.tryhard.listeners.PlayerListener;
import net.farugames.game.tryhard.manager.GameStatus;
import net.farugames.game.tryhard.manager.MapGameInfos;
import net.farugames.game.tryhard.manager.teams.TeamInfo;
import net.farugames.game.tryhard.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Tryhard extends JavaPlugin {

    public static List<Location> spawnLocations = new ArrayList<Location>();
    public static Tryhard instance;
    private static Map<String, TryHardPlayer> gamePlayersMap = new HashMap<String, TryHardPlayer>();
    public List<MapGameInfos> mapInfosList = new ArrayList<MapGameInfos>();
    public List<TeamInfo> teamInGameList = new ArrayList<TeamInfo>();
    public int maxPlayerPerTeam = getConfig().getInt("playerPerTeam");
    public Integer minPlayers = 8;
    public String maxPlayers;
    public int playerLeft;

    public MapGameInfos mapGameInfos;
    public FileManager.Config mapLocationsConfig;
    public FileManager fileManager;

    public boolean damage = false;
    public boolean canMove = true;
    public boolean forceStart = false;

    public static String getPrefix() {
        return "§a§lTryHard";
    }

    public static String centerText(String text) {
        int space = (int) Math.round((80.0D - 1.4D * text.length()) / 2.0D);
        return repeat(" ", space) + text;
    }

    private static String repeat(String text, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(text);
        }
        return stringBuilder.toString();
    }

    public static String getChatPrefix() {
        return "§7[§a§lTryHard§r§7] §r";
    }

    public static TryHardPlayer getTryPlayer(Player player) {
        if(gamePlayersMap.get(player.getName()) == null) { gamePlayersMap.put(player.getName(), new TryHardPlayer(player)); }
        return gamePlayersMap.get(player.getName());
    }

    @Override
    public void onLoad() {
        for(MapGameInfos mapInfos : MapGameInfos.values()) { mapInfosList.add(mapInfos); }
        this.mapGameInfos = mapInfosList.get(0);
//        this.mapGameInfos = mapInfosList.get(new Random().nextInt(mapInfosList.size()));

//        mapLocationsConfig = fileManager.getConfig("maps/" + mapGameInfos.getConfigName());
//        mapLocationsConfig.copyDefaults(true).save();

        GameStatus.setStatus(GameStatus.LOBBY);

        this.saveDefaultConfig();
    }

    @Override
    public void onEnable() {

        instance = this;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinLeaveListener(), this);
        pm.registerEvents(new PlayerListener(), this);

        getCommand("gamestart").setExecutor(new StartCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
