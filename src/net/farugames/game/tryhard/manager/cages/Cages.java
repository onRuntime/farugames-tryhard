package net.farugames.game.tryhard.manager.cages;

import org.bukkit.Location;
import org.bukkit.Material;

/**
 * Created by SweetKebab_ on 2018-07-10
 */
public class Cages {
    public CageEnum cageEnum;
    public Material material;
    public short data;
    public Location location;

    public Cages(CageEnum cageEnum, Location location)
    {
        this.cageEnum = cageEnum;
        this.material = cageEnum.getMaterial();
        this.data = cageEnum.getData();
        this.location = location;
    }

    public CageEnum getCageEnum()
    {
        return this.cageEnum;
    }

    public Material getMaterial()
    {
        return this.material;
    }

    public short getData()
    {
        return this.data;
    }

    public Location getLocation()
    {
        return this.location;
    }
    public void createCage()
    {
        this.location.getBlock().setType(Material.REDSTONE_LAMP_ON);
        this.location.getBlock().getRelative(0, 0, 1).setType(this.material);
        this.location.getBlock().getRelative(0, 0, 2).setType(this.material);
        this.location.getBlock().getRelative(0, 0, -1).setType(this.material);
        this.location.getBlock().getRelative(0, 0, -2).setType(this.material);
        this.location.getBlock().getRelative(1, 0, 0).setType(this.material);
        this.location.getBlock().getRelative(-1, 0, 0).setType(this.material);
        this.location.getBlock().getRelative(1, 0, -1).setType(this.material);
        this.location.getBlock().getRelative(-1, 0, -1).setType(this.material);
        this.location.getBlock().getRelative(1, 0, 1).setType(this.material);
        this.location.getBlock().getRelative(-1, 0, 1).setType(this.material);
        this.location.getBlock().getRelative(0, 0, 1).setData((byte)this.data);
        this.location.getBlock().getRelative(0, 0, 2).setData((byte)this.data);
        this.location.getBlock().getRelative(0, 0, -1).setData((byte)this.data);
        this.location.getBlock().getRelative(0, 0, -2).setData((byte)this.data);
        this.location.getBlock().getRelative(1, 0, 0).setData((byte)this.data);
        this.location.getBlock().getRelative(-1, 0, 0).setData((byte)this.data);
        this.location.getBlock().getRelative(1, 0, -1).setData((byte)this.data);
        this.location.getBlock().getRelative(-1, 0, -1).setData((byte)this.data);
        this.location.getBlock().getRelative(1, 0, 1).setData((byte)this.data);
        this.location.getBlock().getRelative(-1, 0, 1).setData((byte)this.data);
        this.location.getBlock().getRelative(0, 0, -3).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(0, 0, 3).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(2, 0, 1).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(2, 0, 0).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(2, 0, -1).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(-2, 0, 1).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(-2, 0, 0).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(-2, 0, -1).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(-1, 0, 2).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(-1, 0, -2).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(1, 0, 2).setType(Material.COAL_BLOCK);
        this.location.getBlock().getRelative(1, 0, -2).setType(Material.COAL_BLOCK);
    }

    public void removeCage()
    {
        this.location.getBlock().setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, 1).setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, 2).setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, -1).setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, -2).setType(Material.AIR);
        this.location.getBlock().getRelative(1, 0, 0).setType(Material.AIR);
        this.location.getBlock().getRelative(-1, 0, 0).setType(Material.AIR);
        this.location.getBlock().getRelative(1, 0, -1).setType(Material.AIR);
        this.location.getBlock().getRelative(-1, 0, -1).setType(Material.AIR);
        this.location.getBlock().getRelative(1, 0, 1).setType(Material.AIR);
        this.location.getBlock().getRelative(-1, 0, 1).setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, -3).setType(Material.AIR);
        this.location.getBlock().getRelative(0, 0, 3).setType(Material.AIR);
        this.location.getBlock().getRelative(2, 0, 1).setType(Material.AIR);
        this.location.getBlock().getRelative(2, 0, 0).setType(Material.AIR);
        this.location.getBlock().getRelative(2, 0, -1).setType(Material.AIR);
        this.location.getBlock().getRelative(-2, 0, 1).setType(Material.AIR);
        this.location.getBlock().getRelative(-2, 0, 0).setType(Material.AIR);
        this.location.getBlock().getRelative(-2, 0, -1).setType(Material.AIR);
        this.location.getBlock().getRelative(-1, 0, 2).setType(Material.AIR);
        this.location.getBlock().getRelative(-1, 0, -2).setType(Material.AIR);
        this.location.getBlock().getRelative(1, 0, 2).setType(Material.AIR);
        this.location.getBlock().getRelative(1, 0, -2).setType(Material.AIR);
    }
}
