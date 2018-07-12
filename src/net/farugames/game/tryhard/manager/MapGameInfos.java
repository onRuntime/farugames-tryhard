package net.farugames.game.tryhard.manager;

/**
 * Created by SweetKebab_ on 2018-07-11
 */
public enum MapGameInfos {

    DEFAULT("Défaut", "default.yml");

    public String mapName;
    public String configName;

    private MapGameInfos(String mapName, String configName) {
        this.mapName = mapName;
        this.configName = configName;
    }

    public String getMapName() {
        return mapName;
    }

    public String getConfigName() {
        return configName;
    }
}