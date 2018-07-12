package net.farugames.game.tryhard.manager.cages;

import org.bukkit.Material;

/**
 * Created by SweetKebab_ on 2018-07-10
 */
public enum  CageEnum {
    DEFAULT(1, "Défaut", Material.GLASS, (short) 0, null, 1, 20);

    public int id;
    public String name;
    public Material material;
    public short data;
    public String permission;
    public int page;
    public int slot;

    private CageEnum(int id, String name, Material material, short data, String permission, int page, int slot) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.data = data;
        this.permission = permission;
        this.page = page;
        this.slot = slot;
    }

    public static CageEnum getCageByName(String cageName) {
        for(CageEnum cagesInfo : CageEnum.values()) {
            if(cagesInfo.getName().equalsIgnoreCase(cageName)) {
                return cagesInfo;
            }
        }
        return CageEnum.DEFAULT;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public short getData() {
        return data;
    }

    public String getPermission() {
        return permission;
    }

    public int getPage() {
        return page;
    }

    public int getSlot() {
        return slot;
    }
}
